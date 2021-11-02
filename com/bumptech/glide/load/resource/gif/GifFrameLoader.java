package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class GifFrameLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitmapPool bitmapPool;
    public final List<FrameCallback> callbacks;
    public DelayTarget current;
    public Bitmap firstFrame;
    public final GifDecoder gifDecoder;
    public final Handler handler;
    public boolean isCleared;
    public boolean isLoadPending;
    public boolean isRunning;
    public DelayTarget next;
    @Nullable
    public OnEveryFrameListener onEveryFrameListener;
    public DelayTarget pendingTarget;
    public RequestBuilder<Bitmap> requestBuilder;
    public final RequestManager requestManager;
    public boolean startFromFirstFrame;
    public Transformation<Bitmap> transformation;

    @VisibleForTesting
    /* loaded from: classes11.dex */
    public static class DelayTarget extends SimpleTarget<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler handler;
        public final int index;
        public Bitmap resource;
        public final long targetTime;

        public DelayTarget(Handler handler, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.handler = handler;
            this.index = i2;
            this.targetTime = j;
        }

        public Bitmap getResource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.resource : (Bitmap) invokeV.objValue;
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }

        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, transition) == null) {
                this.resource = bitmap;
                this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.targetTime);
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface FrameCallback {
        void onFrameReady();
    }

    /* loaded from: classes11.dex */
    public class FrameLoaderCallback implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MSG_CLEAR = 2;
        public static final int MSG_DELAY = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GifFrameLoader this$0;

        public FrameLoaderCallback(GifFrameLoader gifFrameLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifFrameLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = gifFrameLoader;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 1) {
                    this.this$0.onFrameReady((DelayTarget) message.obj);
                    return true;
                } else if (i2 == 2) {
                    this.this$0.requestManager.clear((DelayTarget) message.obj);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    @VisibleForTesting
    /* loaded from: classes11.dex */
    public interface OnEveryFrameListener {
        void onFrameReady();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i2, int i3, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.getBitmapPool(), Glide.with(glide.getContext()), gifDecoder, null, getRequestBuilder(Glide.with(glide.getContext()), i2, i3), transformation, bitmap);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r5;
            Object[] objArr = {glide, gifDecoder, Integer.valueOf(i2), Integer.valueOf(i3), transformation, bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((BitmapPool) objArr2[0], (RequestManager) objArr2[1], (GifDecoder) objArr2[2], (Handler) objArr2[3], (RequestBuilder) objArr2[4], (Transformation) objArr2[5], (Bitmap) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static Key getFrameSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new ObjectKey(Double.valueOf(Math.random())) : (Key) invokeV.objValue;
    }

    private int getFrameSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? Util.getBitmapByteSize(getCurrentFrame().getWidth(), getCurrentFrame().getHeight(), getCurrentFrame().getConfig()) : invokeV.intValue;
    }

    public static RequestBuilder<Bitmap> getRequestBuilder(RequestManager requestManager, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, requestManager, i2, i3)) == null) ? requestManager.asBitmap().apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true).skipMemoryCache(true).override(i2, i3)) : (RequestBuilder) invokeLII.objValue;
    }

    private void loadNextFrame() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && this.isRunning && !this.isLoadPending) {
            if (this.startFromFirstFrame) {
                Preconditions.checkArgument(this.pendingTarget == null, "Pending target must be null when starting from the first frame");
                this.gifDecoder.resetFrameIndex();
                this.startFromFirstFrame = false;
            }
            DelayTarget delayTarget = this.pendingTarget;
            if (delayTarget != null) {
                this.pendingTarget = null;
                onFrameReady(delayTarget);
                return;
            }
            this.isLoadPending = true;
            long uptimeMillis = SystemClock.uptimeMillis() + this.gifDecoder.getNextDelay();
            this.gifDecoder.advance();
            this.next = new DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), uptimeMillis);
            this.requestBuilder.apply(RequestOptions.signatureOf(getFrameSignature())).load((Object) this.gifDecoder).into((RequestBuilder<Bitmap>) this.next);
        }
    }

    private void recycleFirstFrame() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (bitmap = this.firstFrame) == null) {
            return;
        }
        this.bitmapPool.put(bitmap);
        this.firstFrame = null;
    }

    private void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.isCleared = false;
        loadNextFrame();
    }

    private void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.isRunning = false;
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.callbacks.clear();
            recycleFirstFrame();
            stop();
            DelayTarget delayTarget = this.current;
            if (delayTarget != null) {
                this.requestManager.clear(delayTarget);
                this.current = null;
            }
            DelayTarget delayTarget2 = this.next;
            if (delayTarget2 != null) {
                this.requestManager.clear(delayTarget2);
                this.next = null;
            }
            DelayTarget delayTarget3 = this.pendingTarget;
            if (delayTarget3 != null) {
                this.requestManager.clear(delayTarget3);
                this.pendingTarget = null;
            }
            this.gifDecoder.clear();
            this.isCleared = true;
        }
    }

    public ByteBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.gifDecoder.getData().asReadOnlyBuffer() : (ByteBuffer) invokeV.objValue;
    }

    public Bitmap getCurrentFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            DelayTarget delayTarget = this.current;
            return delayTarget != null ? delayTarget.getResource() : this.firstFrame;
        }
        return (Bitmap) invokeV.objValue;
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            DelayTarget delayTarget = this.current;
            if (delayTarget != null) {
                return delayTarget.index;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public Bitmap getFirstFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.firstFrame : (Bitmap) invokeV.objValue;
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.gifDecoder.getFrameCount() : invokeV.intValue;
    }

    public Transformation<Bitmap> getFrameTransformation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.transformation : (Transformation) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getCurrentFrame().getHeight() : invokeV.intValue;
    }

    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.gifDecoder.getTotalIterationCount() : invokeV.intValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.gifDecoder.getByteSize() + getFrameSize() : invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getCurrentFrame().getWidth() : invokeV.intValue;
    }

    @VisibleForTesting
    public void onFrameReady(DelayTarget delayTarget) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, delayTarget) == null) {
            OnEveryFrameListener onEveryFrameListener = this.onEveryFrameListener;
            if (onEveryFrameListener != null) {
                onEveryFrameListener.onFrameReady();
            }
            this.isLoadPending = false;
            if (this.isCleared) {
                this.handler.obtainMessage(2, delayTarget).sendToTarget();
            } else if (!this.isRunning) {
                this.pendingTarget = delayTarget;
            } else {
                if (delayTarget.getResource() != null) {
                    recycleFirstFrame();
                    DelayTarget delayTarget2 = this.current;
                    this.current = delayTarget;
                    for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                        this.callbacks.get(size).onFrameReady();
                    }
                    if (delayTarget2 != null) {
                        this.handler.obtainMessage(2, delayTarget2).sendToTarget();
                    }
                }
                loadNextFrame();
            }
        }
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, transformation, bitmap) == null) {
            this.transformation = (Transformation) Preconditions.checkNotNull(transformation);
            this.firstFrame = (Bitmap) Preconditions.checkNotNull(bitmap);
            this.requestBuilder = this.requestBuilder.apply(new RequestOptions().transform(transformation));
        }
    }

    public void setNextStartFromFirstFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Preconditions.checkArgument(!this.isRunning, "Can't restart a running animation");
            this.startFromFirstFrame = true;
            DelayTarget delayTarget = this.pendingTarget;
            if (delayTarget != null) {
                this.requestManager.clear(delayTarget);
                this.pendingTarget = null;
            }
        }
    }

    @VisibleForTesting
    public void setOnEveryFrameReadyListener(@Nullable OnEveryFrameListener onEveryFrameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onEveryFrameListener) == null) {
            this.onEveryFrameListener = onEveryFrameListener;
        }
    }

    public void subscribe(FrameCallback frameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, frameCallback) == null) {
            if (!this.isCleared) {
                if (!this.callbacks.contains(frameCallback)) {
                    boolean isEmpty = this.callbacks.isEmpty();
                    this.callbacks.add(frameCallback);
                    if (isEmpty) {
                        start();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
    }

    public void unsubscribe(FrameCallback frameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, frameCallback) == null) {
            this.callbacks.remove(frameCallback);
            if (this.callbacks.isEmpty()) {
                stop();
            }
        }
    }

    public GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmapPool, requestManager, gifDecoder, handler, requestBuilder, transformation, bitmap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.callbacks = new ArrayList();
        this.requestManager = requestManager;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new FrameLoaderCallback(this)) : handler;
        this.bitmapPool = bitmapPool;
        this.handler = handler;
        this.requestBuilder = requestBuilder;
        this.gifDecoder = gifDecoder;
        setFrameTransformation(transformation, bitmap);
    }
}
