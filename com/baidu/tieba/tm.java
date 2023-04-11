package com.baidu.tieba;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tm extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RectF a;
    public final RectF b;
    public final RectF c;
    public final BitmapShader d;
    public final Paint e;
    public final int f;
    public final int g;
    public final RectF h;
    public final Paint i;
    public final Matrix j;
    public float k;
    public boolean l;
    public float m;
    public ColorStateList n;
    public ImageView.ScaleType o;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(264209655, "Lcom/baidu/tieba/tm$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(264209655, "Lcom/baidu/tieba/tm$a;");
                    return;
                }
            }
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public tm(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new RectF();
        this.b = new RectF();
        this.c = new RectF();
        this.h = new RectF();
        this.j = new Matrix();
        this.k = 0.0f;
        this.l = false;
        this.m = 0.0f;
        this.n = ColorStateList.valueOf(0);
        this.o = ImageView.ScaleType.FIT_XY;
        this.f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.g = height;
        this.c.set(0.0f, 0.0f, this.f, height);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.d = bitmapShader;
        bitmapShader.setLocalMatrix(this.j);
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.e.setAntiAlias(true);
        this.e.setShader(this.d);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.i.setAntiAlias(true);
        this.i.setColor(this.n.getColorForState(getState(), 0));
        this.i.setStrokeWidth(this.m);
    }

    public static Bitmap a(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, drawable)) == null) {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Drawable b(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, drawable)) == null) {
            if (drawable != null) {
                if (drawable instanceof tm) {
                    return drawable;
                }
                if (drawable instanceof ColorDrawable) {
                    return drawable;
                }
                if (drawable instanceof LayerDrawable) {
                    LayerDrawable layerDrawable = (LayerDrawable) drawable;
                    int numberOfLayers = layerDrawable.getNumberOfLayers();
                    for (int i = 0; i < numberOfLayers; i++) {
                        layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), b(layerDrawable.getDrawable(i)));
                    }
                    return layerDrawable;
                } else if (drawable instanceof StateListDrawable) {
                    return (StateListDrawable) drawable;
                } else {
                    Bitmap a2 = a(drawable);
                    if (a2 != null && !a2.isRecycled()) {
                        return new tm(a2);
                    }
                    Log.w("BdRoundedDrawable", "Failed to create bitmap from drawable!");
                }
            }
            return drawable;
        }
        return (Drawable) invokeL.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.l) {
                if (this.m > 0.0f) {
                    canvas.drawOval(this.h, this.i);
                    canvas.drawOval(this.b, this.e);
                    return;
                }
                canvas.drawOval(this.b, this.e);
            } else if (this.m > 0.0f) {
                RectF rectF = this.h;
                float f = this.k;
                canvas.drawRoundRect(rectF, f, f, this.i);
                canvas.drawRoundRect(this.b, Math.max(this.k - this.m, 0.0f), Math.max(this.k - this.m, 0.0f), this.e);
            } else {
                RectF rectF2 = this.b;
                float f2 = this.k;
                canvas.drawRoundRect(rectF2, f2, f2, this.e);
            }
        }
    }

    public tm c(ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, colorStateList)) == null) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.n = colorStateList;
            this.i.setColor(colorStateList.getColorForState(getState(), 0));
            return this;
        }
        return (tm) invokeL.objValue;
    }

    public tm d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            float f = i;
            this.m = f;
            this.i.setStrokeWidth(f);
            return this;
        }
        return (tm) invokeI.objValue;
    }

    public tm e(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f)) == null) {
            this.k = f;
            return this;
        }
        return (tm) invokeF.objValue;
    }

    public tm f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.l = z;
            return this;
        }
        return (tm) invokeZ.objValue;
    }

    public tm g(ImageView.ScaleType scaleType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, scaleType)) == null) {
            if (scaleType == null) {
                scaleType = ImageView.ScaleType.FIT_XY;
            }
            if (this.o != scaleType) {
                this.o = scaleType;
                h();
            }
            return this;
        }
        return (tm) invokeL.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rect) == null) {
            super.onBoundsChange(rect);
            this.a.set(rect);
            h();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, iArr)) == null) {
            int colorForState = this.n.getColorForState(iArr, 0);
            if (this.i.getColor() != colorForState) {
                this.i.setColor(colorForState);
                return true;
            }
            return super.onStateChange(iArr);
        }
        return invokeL.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.e.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, colorFilter) == null) {
            this.e.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.n.isStateful();
        }
        return invokeV.booleanValue;
    }

    public final void h() {
        float width;
        float height;
        float min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.h.set(this.a);
            RectF rectF = this.b;
            float f = this.m;
            rectF.set(f, f, this.h.width() - this.m, this.h.height() - this.m);
            float f2 = 0.0f;
            switch (a.a[this.o.ordinal()]) {
                case 1:
                    this.h.set(this.a);
                    RectF rectF2 = this.b;
                    float f3 = this.m;
                    rectF2.set(f3, f3, this.h.width() - this.m, this.h.height() - this.m);
                    this.j.set(null);
                    this.j.setTranslate((int) (((this.b.width() - this.f) * 0.5f) + 0.5f), (int) (((this.b.height() - this.g) * 0.5f) + 0.5f));
                    break;
                case 2:
                    this.h.set(this.a);
                    RectF rectF3 = this.b;
                    float f4 = this.m;
                    rectF3.set(f4, f4, this.h.width() - this.m, this.h.height() - this.m);
                    this.j.set(null);
                    if (this.f * this.b.height() > this.b.width() * this.g) {
                        width = this.b.height() / this.g;
                        f2 = (this.b.width() - (this.f * width)) * 0.5f;
                        height = 0.0f;
                    } else {
                        width = this.b.width() / this.f;
                        height = (this.b.height() - (this.g * width)) * 0.5f;
                    }
                    this.j.setScale(width, width);
                    Matrix matrix = this.j;
                    float f5 = this.m;
                    matrix.postTranslate(((int) (f2 + 0.5f)) + f5, ((int) (height + 0.5f)) + f5);
                    break;
                case 3:
                    this.j.set(null);
                    if (this.f <= this.a.width() && this.g <= this.a.height()) {
                        min = 1.0f;
                    } else {
                        min = Math.min(this.a.width() / this.f, this.a.height() / this.g);
                    }
                    this.j.setScale(min, min);
                    this.j.postTranslate((int) (((this.a.width() - (this.f * min)) * 0.5f) + 0.5f), (int) (((this.a.height() - (this.g * min)) * 0.5f) + 0.5f));
                    this.h.set(this.c);
                    this.j.mapRect(this.h);
                    RectF rectF4 = this.b;
                    RectF rectF5 = this.h;
                    float f6 = rectF5.left;
                    float f7 = this.m;
                    rectF4.set(f6 + f7, rectF5.top + f7, rectF5.right - f7, rectF5.bottom - f7);
                    this.j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                    break;
                case 4:
                    this.h.set(this.c);
                    this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
                    this.j.mapRect(this.h);
                    RectF rectF6 = this.b;
                    RectF rectF7 = this.h;
                    float f8 = rectF7.left;
                    float f9 = this.m;
                    rectF6.set(f8 + f9, rectF7.top + f9, rectF7.right - f9, rectF7.bottom - f9);
                    this.j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                    break;
                case 5:
                    this.h.set(this.c);
                    this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
                    this.j.mapRect(this.h);
                    RectF rectF8 = this.b;
                    RectF rectF9 = this.h;
                    float f10 = rectF9.left;
                    float f11 = this.m;
                    rectF8.set(f10 + f11, rectF9.top + f11, rectF9.right - f11, rectF9.bottom - f11);
                    this.j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                    break;
                case 6:
                    this.h.set(this.c);
                    this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
                    this.j.mapRect(this.h);
                    RectF rectF10 = this.b;
                    RectF rectF11 = this.h;
                    float f12 = rectF11.left;
                    float f13 = this.m;
                    rectF10.set(f12 + f13, rectF11.top + f13, rectF11.right - f13, rectF11.bottom - f13);
                    this.j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                    break;
                default:
                    this.h.set(this.a);
                    RectF rectF12 = this.b;
                    float f14 = this.m;
                    rectF12.set(f14 + 0.0f, f14 + 0.0f, this.h.width() - this.m, this.h.height() - this.m);
                    this.j.set(null);
                    this.j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                    break;
            }
            RectF rectF13 = this.h;
            float f15 = this.m;
            rectF13.inset(f15 / 2.0f, f15 / 2.0f);
            this.d.setLocalMatrix(this.j);
        }
    }
}
