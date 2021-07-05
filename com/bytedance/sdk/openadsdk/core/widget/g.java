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
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.core.o;
/* loaded from: classes6.dex */
public class g extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    public int f30756a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int f30757b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public int[] f30758c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public float[] f30759d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public LinearGradient f30760e;

    /* renamed from: f  reason: collision with root package name */
    public int f30761f;

    /* renamed from: g  reason: collision with root package name */
    public int f30762g;

    /* renamed from: h  reason: collision with root package name */
    public int f30763h;

    /* renamed from: i  reason: collision with root package name */
    public int f30764i;
    @Nullable
    public RectF j;
    @Nullable
    public Paint k;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @ColorInt

        /* renamed from: a  reason: collision with root package name */
        public int f30765a;
        @ColorInt

        /* renamed from: b  reason: collision with root package name */
        public int f30766b;

        /* renamed from: c  reason: collision with root package name */
        public int[] f30767c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public float[] f30768d;

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f30769e;

        /* renamed from: f  reason: collision with root package name */
        public int f30770f;

        /* renamed from: g  reason: collision with root package name */
        public int f30771g;

        /* renamed from: h  reason: collision with root package name */
        public int f30772h;

        /* renamed from: i  reason: collision with root package name */
        public int f30773i;

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
            this.f30772h = 0;
            this.f30773i = 0;
            this.f30765a = r.j(o.a(), "tt_ssxinmian8");
            this.f30766b = r.j(o.a(), "tt_ssxinxian3");
            this.f30770f = 10;
            this.f30771g = 16;
            this.f30772h = 0;
            this.f30773i = 0;
        }

        public a a(@ColorInt int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f30765a = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a b(@ColorInt int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f30766b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f30770f = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.f30772h = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f30773i = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(@Nullable int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr)) == null) {
                this.f30767c = iArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new g(this.f30765a, this.f30767c, this.f30768d, this.f30766b, this.f30769e, this.f30770f, this.f30771g, this.f30772h, this.f30773i) : (g) invokeV.objValue;
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
        this.f30756a = i2;
        this.f30758c = iArr;
        this.f30759d = fArr;
        this.f30757b = i3;
        this.f30760e = linearGradient;
        this.f30761f = i4;
        this.f30762g = i5;
        this.f30763h = i6;
        this.f30764i = i7;
    }

    private void a() {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Paint paint = new Paint();
            this.k = paint;
            boolean z = true;
            paint.setAntiAlias(true);
            this.k.setShadowLayer(this.f30762g, this.f30763h, this.f30764i, this.f30757b);
            if (this.j != null && (iArr = this.f30758c) != null && iArr.length > 1) {
                float[] fArr = this.f30759d;
                z = (fArr == null || fArr.length <= 0 || fArr.length != iArr.length) ? false : false;
                Paint paint2 = this.k;
                LinearGradient linearGradient = this.f30760e;
                if (linearGradient == null) {
                    RectF rectF = this.j;
                    linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.f30758c, z ? this.f30759d : null, Shader.TileMode.CLAMP);
                }
                paint2.setShader(linearGradient);
                return;
            }
            this.k.setColor(this.f30756a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.j == null) {
                Rect bounds = getBounds();
                int i2 = bounds.left;
                int i3 = this.f30762g;
                int i4 = this.f30763h;
                int i5 = this.f30764i;
                this.j = new RectF((i2 + i3) - i4, (bounds.top + i3) - i5, (bounds.right - i3) - i4, (bounds.bottom - i3) - i5);
            }
            if (this.k == null) {
                a();
            }
            RectF rectF = this.j;
            int i6 = this.f30761f;
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
