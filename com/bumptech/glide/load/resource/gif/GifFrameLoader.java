package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class GifFrameLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitmapPool bitmapPool;
    public final List callbacks;
    public DelayTarget current;
    public Bitmap firstFrame;
    public int firstFrameSize;
    public final GifDecoder gifDecoder;
    public final Handler handler;
    public int height;
    public boolean isCleared;
    public boolean isLoadPending;
    public boolean isRunning;
    public DelayTarget next;
    public OnEveryFrameListener onEveryFrameListener;
    public DelayTarget pendingTarget;
    public RequestBuilder requestBuilder;
    public final RequestManager requestManager;
    public boolean startFromFirstFrame;
    public Transformation transformation;
    public int width;

    /* loaded from: classes7.dex */
    public interface FrameCallback {
        void onFrameReady();
    }

    /* loaded from: classes7.dex */
    public interface OnEveryFrameListener {
        void onFrameReady();
    }

    /* loaded from: classes7.dex */
    public class DelayTarget extends CustomTarget {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler handler;
        public final int index;
        public Bitmap resource;
        public final long targetTime;

        public DelayTarget(Handler handler, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.handler = handler;
            this.index = i;
            this.targetTime = j;
        }

        public Bitmap getResource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.resource;
            }
            return (Bitmap) invokeV.objValue;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable) == null) {
                this.resource = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Bitmap bitmap, Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bitmap, transition) == null) {
                this.resource = bitmap;
                this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.targetTime);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = message.what;
                if (i == 1) {
                    this.this$0.onFrameReady((DelayTarget) message.obj);
                    return true;
                } else if (i == 2) {
                    this.this$0.requestManager.clear((DelayTarget) message.obj);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i, int i2, Transformation transformation, Bitmap bitmap) {
        this(glide.getBitmapPool(), Glide.with(glide.getContext()), gifDecoder, null, getRequestBuilder(Glide.with(glide.getContext()), i, i2), transformation, bitmap);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r5;
            Object[] objArr = {glide, gifDecoder, Integer.valueOf(i), Integer.valueOf(i2), transformation, bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((BitmapPool) objArr2[0], (RequestManager) objArr2[1], (GifDecoder) objArr2[2], (Handler) objArr2[3], (RequestBuilder) objArr2[4], (Transformation) objArr2[5], (Bitmap) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, RequestBuilder requestBuilder, Transformation transformation, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmapPool, requestManager, gifDecoder, handler, requestBuilder, transformation, bitmap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public static Key getFrameSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new ObjectKey(Double.valueOf(Math.random()));
        }
        return (Key) invokeV.objValue;
    }

    private void recycleFirstFrame() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && (bitmap = this.firstFrame) != null) {
            this.bitmapPool.put(bitmap);
            this.firstFrame = null;
        }
    }

    private void start() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65542, this) != null) || this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.isCleared = false;
        loadNextFrame();
    }

    private void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.isRunning = false;
        }
    }

    public ByteBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.gifDecoder.getData().asReadOnlyBuffer();
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public Bitmap getCurrentFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            DelayTarget delayTarget = this.current;
            if (delayTarget != null) {
                return delayTarget.getResource();
            }
            return this.firstFrame;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.firstFrame;
        }
        return (Bitmap) invokeV.objValue;
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.gifDecoder.getFrameCount();
        }
        return invokeV.intValue;
    }

    public Transformation getFrameTransformation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.transformation;
        }
        return (Transformation) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.height;
        }
        return invokeV.intValue;
    }

    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.gifDecoder.getTotalIterationCount();
        }
        return invokeV.intValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.gifDecoder.getByteSize() + this.firstFrameSize;
        }
        return invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.width;
        }
        return invokeV.intValue;
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

    public static RequestBuilder getRequestBuilder(RequestManager requestManager, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, requestManager, i, i2)) == null) {
            return requestManager.asBitmap().apply(((RequestOptions) ((RequestOptions) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true)).skipMemoryCache(true)).override(i, i2));
        }
        return (RequestBuilder) invokeLII.objValue;
    }

    private void loadNextFrame() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.isRunning && !this.isLoadPending) {
            if (this.startFromFirstFrame) {
                if (this.pendingTarget == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "Pending target must be null when starting from the first frame");
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
            this.requestBuilder.apply((BaseRequestOptions) RequestOptions.signatureOf(getFrameSignature())).load((Object) this.gifDecoder).into(this.next);
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
                if (this.startFromFirstFrame) {
                    this.handler.obtainMessage(2, delayTarget).sendToTarget();
                } else {
                    this.pendingTarget = delayTarget;
                }
            } else {
                if (delayTarget.getResource() != null) {
                    recycleFirstFrame();
                    DelayTarget delayTarget2 = this.current;
                    this.current = delayTarget;
                    for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                        ((FrameCallback) this.callbacks.get(size)).onFrameReady();
                    }
                    if (delayTarget2 != null) {
                        this.handler.obtainMessage(2, delayTarget2).sendToTarget();
                    }
                }
                loadNextFrame();
            }
        }
    }

    public void setFrameTransformation(Transformation transformation, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, transformation, bitmap) == null) {
            this.transformation = (Transformation) Preconditions.checkNotNull(transformation);
            this.firstFrame = (Bitmap) Preconditions.checkNotNull(bitmap);
            this.requestBuilder = this.requestBuilder.apply(new RequestOptions().transform(transformation));
            this.firstFrameSize = Util.getBitmapByteSize(bitmap);
            this.width = bitmap.getWidth();
            this.height = bitmap.getHeight();
        }
    }

    public void setOnEveryFrameReadyListener(OnEveryFrameListener onEveryFrameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onEveryFrameListener) == null) {
            this.onEveryFrameListener = onEveryFrameListener;
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
}
