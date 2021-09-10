package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.o;
/* loaded from: classes9.dex */
public class g extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    public int f67364a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int f67365b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public int[] f67366c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public float[] f67367d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public LinearGradient f67368e;

    /* renamed from: f  reason: collision with root package name */
    public int f67369f;

    /* renamed from: g  reason: collision with root package name */
    public int f67370g;

    /* renamed from: h  reason: collision with root package name */
    public int f67371h;

    /* renamed from: i  reason: collision with root package name */
    public int f67372i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public RectF f67373j;
    @Nullable
    public Paint k;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @ColorInt

        /* renamed from: a  reason: collision with root package name */
        public int f67374a;
        @ColorInt

        /* renamed from: b  reason: collision with root package name */
        public int f67375b;

        /* renamed from: c  reason: collision with root package name */
        public int[] f67376c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public float[] f67377d;

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f67378e;

        /* renamed from: f  reason: collision with root package name */
        public int f67379f;

        /* renamed from: g  reason: collision with root package name */
        public int f67380g;

        /* renamed from: h  reason: collision with root package name */
        public int f67381h;

        /* renamed from: i  reason: collision with root package name */
        public int f67382i;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67381h = 0;
            this.f67382i = 0;
            this.f67374a = t.j(o.a(), "tt_ssxinmian8");
            this.f67375b = t.j(o.a(), "tt_ssxinxian3");
            this.f67379f = 10;
            this.f67380g = 16;
            this.f67381h = 0;
            this.f67382i = 0;
        }

        public a a(@ColorInt int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f67374a = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(@ColorInt int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f67375b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f67379f = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.f67381h = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f67382i = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(@Nullable int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr)) == null) {
                this.f67376c = iArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new g(this.f67374a, this.f67376c, this.f67377d, this.f67375b, this.f67378e, this.f67379f, this.f67380g, this.f67381h, this.f67382i) : (g) invokeV.objValue;
        }
    }

    public g(@ColorInt int i2, @Nullable int[] iArr, @Nullable float[] fArr, @ColorInt int i3, @Nullable LinearGradient linearGradient, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), iArr, fArr, Integer.valueOf(i3), linearGradient, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67364a = i2;
        this.f67366c = iArr;
        this.f67367d = fArr;
        this.f67365b = i3;
        this.f67368e = linearGradient;
        this.f67369f = i4;
        this.f67370g = i5;
        this.f67371h = i6;
        this.f67372i = i7;
    }

    private void a() {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Paint paint = new Paint();
            this.k = paint;
            boolean z = true;
            paint.setAntiAlias(true);
            this.k.setShadowLayer(this.f67370g, this.f67371h, this.f67372i, this.f67365b);
            if (this.f67373j != null && (iArr = this.f67366c) != null && iArr.length > 1) {
                float[] fArr = this.f67367d;
                z = (fArr == null || fArr.length <= 0 || fArr.length != iArr.length) ? false : false;
                Paint paint2 = this.k;
                LinearGradient linearGradient = this.f67368e;
                if (linearGradient == null) {
                    RectF rectF = this.f67373j;
                    linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.f67366c, z ? this.f67367d : null, Shader.TileMode.CLAMP);
                }
                paint2.setShader(linearGradient);
                return;
            }
            this.k.setColor(this.f67364a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.f67373j == null) {
                Rect bounds = getBounds();
                int i2 = bounds.left;
                int i3 = this.f67370g;
                int i4 = this.f67371h;
                int i5 = this.f67372i;
                this.f67373j = new RectF((i2 + i3) - i4, (bounds.top + i3) - i5, (bounds.right - i3) - i4, (bounds.bottom - i3) - i5);
            }
            if (this.k == null) {
                a();
            }
            RectF rectF = this.f67373j;
            int i6 = this.f67369f;
            canvas.drawRoundRect(rectF, i6, i6, this.k);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (paint = this.k) == null) {
            return;
        }
        paint.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, colorFilter) == null) || (paint = this.k) == null) {
            return;
        }
        paint.setColorFilter(colorFilter);
    }

    public static void a(View view, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, view, aVar) == null) || view == null || aVar == null) {
            return;
        }
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, aVar.a());
    }
}
