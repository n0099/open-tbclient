package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
/* loaded from: classes12.dex */
public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GRAVITY = 119;
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean applyGravity;
    public Rect destRect;
    public boolean isRecycled;
    public boolean isRunning;
    public boolean isStarted;
    public boolean isVisible;
    public int loopCount;
    public int maxLoopCount;
    public Paint paint;
    public final GifState state;

    /* loaded from: classes12.dex */
    public static final class GifState extends Drawable.ConstantState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @VisibleForTesting
        public final GifFrameLoader frameLoader;

        public GifState(GifFrameLoader gifFrameLoader) {
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
            this.frameLoader = gifFrameLoader;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resources)) == null) ? newDrawable() : (Drawable) invokeL.objValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new GifDrawable(this) : (Drawable) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public GifDrawable(Context context, GifDecoder gifDecoder, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i2, int i3, Bitmap bitmap) {
        this(context, gifDecoder, transformation, i2, i3, bitmap);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gifDecoder, bitmapPool, transformation, Integer.valueOf(i2), Integer.valueOf(i3), bitmap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (GifDecoder) objArr2[1], (Transformation) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), (Bitmap) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private Drawable.Callback findCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            Drawable.Callback callback = getCallback();
            while (callback instanceof Drawable) {
                callback = ((Drawable) callback).getCallback();
            }
            return callback;
        }
        return (Drawable.Callback) invokeV.objValue;
    }

    private Rect getDestRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.destRect == null) {
                this.destRect = new Rect();
            }
            return this.destRect;
        }
        return (Rect) invokeV.objValue;
    }

    private Paint getPaint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.paint == null) {
                this.paint = new Paint(2);
            }
            return this.paint;
        }
        return (Paint) invokeV.objValue;
    }

    private void resetLoopCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.loopCount = 0;
        }
    }

    private void startRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            Preconditions.checkArgument(!this.isRecycled, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
            if (this.state.frameLoader.getFrameCount() == 1) {
                invalidateSelf();
            } else if (this.isRunning) {
            } else {
                this.isRunning = true;
                this.state.frameLoader.subscribe(this);
                invalidateSelf();
            }
        }
    }

    private void stopRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.isRunning = false;
            this.state.frameLoader.unsubscribe(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.isRecycled) {
            return;
        }
        if (this.applyGravity) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), getDestRect());
            this.applyGravity = false;
        }
        canvas.drawBitmap(this.state.frameLoader.getCurrentFrame(), (Rect) null, getDestRect(), getPaint());
    }

    public ByteBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.state.frameLoader.getBuffer() : (ByteBuffer) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.state : (Drawable.ConstantState) invokeV.objValue;
    }

    public Bitmap getFirstFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.state.frameLoader.getFirstFrame() : (Bitmap) invokeV.objValue;
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.state.frameLoader.getFrameCount() : invokeV.intValue;
    }

    public int getFrameIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.state.frameLoader.getCurrentIndex() : invokeV.intValue;
    }

    public Transformation<Bitmap> getFrameTransformation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.state.frameLoader.getFrameTransformation() : (Transformation) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.state.frameLoader.getHeight() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.state.frameLoader.getWidth() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return -2;
        }
        return invokeV.intValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.state.frameLoader.getSize() : invokeV.intValue;
    }

    public boolean isRecycled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.isRecycled : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.isRunning : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, rect) == null) {
            super.onBoundsChange(rect);
            this.applyGravity = true;
        }
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback
    public void onFrameReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (findCallback() == null) {
                stop();
                invalidateSelf();
                return;
            }
            invalidateSelf();
            if (getFrameIndex() == getFrameCount() - 1) {
                this.loopCount++;
            }
            int i2 = this.maxLoopCount;
            if (i2 == -1 || this.loopCount < i2) {
                return;
            }
            stop();
        }
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.isRecycled = true;
            this.state.frameLoader.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            getPaint().setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, colorFilter) == null) {
            getPaint().setColorFilter(colorFilter);
        }
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, transformation, bitmap) == null) {
            this.state.frameLoader.setFrameTransformation(transformation, bitmap);
        }
    }

    public void setIsRunning(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.isRunning = z;
        }
    }

    public void setLoopCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 <= 0 && i2 != -1 && i2 != 0) {
                throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
            }
            if (i2 == 0) {
                int loopCount = this.state.frameLoader.getLoopCount();
                this.maxLoopCount = loopCount != 0 ? loopCount : -1;
                return;
            }
            this.maxLoopCount = i2;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Preconditions.checkArgument(!this.isRecycled, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
            this.isVisible = z;
            if (!z) {
                stopRunning();
            } else if (this.isStarted) {
                startRunning();
            }
            return super.setVisible(z, z2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.isStarted = true;
            resetLoopCount();
            if (this.isVisible) {
                startRunning();
            }
        }
    }

    public void startFromFirstFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Preconditions.checkArgument(!this.isRunning, "You cannot restart a currently running animation.");
            this.state.frameLoader.setNextStartFromFirstFrame();
            start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.isStarted = false;
            stopRunning();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i2, int i3, Bitmap bitmap) {
        this(new GifState(new GifFrameLoader(Glide.get(context), gifDecoder, i2, i3, transformation, bitmap)));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gifDecoder, transformation, Integer.valueOf(i2), Integer.valueOf(i3), bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                this((GifState) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public GifDrawable(GifState gifState) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gifState};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.state = (GifState) Preconditions.checkNotNull(gifState);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public GifDrawable(GifFrameLoader gifFrameLoader, Paint paint) {
        this(new GifState(gifFrameLoader));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gifFrameLoader, paint};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((GifState) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.paint = paint;
    }
}
