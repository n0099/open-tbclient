package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.l.c;
import c.a.d.f.l.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class FrsAnomalyImg extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f36855b;

    /* renamed from: c  reason: collision with root package name */
    public final Path f36856c;

    /* renamed from: d  reason: collision with root package name */
    public int f36857d;

    /* renamed from: e  reason: collision with root package name */
    public b f36858e;

    /* renamed from: f  reason: collision with root package name */
    public int f36859f;

    /* renamed from: g  reason: collision with root package name */
    public int f36860g;

    /* renamed from: h  reason: collision with root package name */
    public int f36861h;
    public int i;
    public int j;
    public int k;
    public Shader l;
    public int m;
    public int n;
    public Shader o;
    public final Matrix p;
    public boolean q;
    public final c<c.a.d.o.d.a> r;

    /* loaded from: classes6.dex */
    public class a extends c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAnomalyImg a;

        public a(FrsAnomalyImg frsAnomalyImg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAnomalyImg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAnomalyImg;
        }

        @Override // c.a.d.f.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // c.a.d.f.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i) == null) || aVar == null) {
                return;
            }
            this.a.m = aVar.r();
            this.a.n = aVar.m();
            this.a.o = aVar.d();
            this.a.invalidate();
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f36862b;

        /* renamed from: c  reason: collision with root package name */
        public int f36863c;

        /* renamed from: d  reason: collision with root package name */
        public int f36864d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public b a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.f36862b = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.f36863c = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.f36864d = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.a = i;
                return this;
            }
            return (b) invokeI.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsAnomalyImg(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int getA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            b bVar = this.f36858e;
            if (bVar != null) {
                return (int) Math.round(this.f36858e.f36864d / Math.tan(Math.toRadians((int) (((bVar.f36862b + 90) / 2) + 0.5d))));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            b bVar = this.f36858e;
            if (bVar != null) {
                return (int) Math.round(this.f36858e.a * Math.tan(Math.toRadians(bVar.f36862b)));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            b bVar = this.f36858e;
            if (bVar != null) {
                return (int) Math.round(getA() * Math.sin(Math.toRadians(bVar.f36862b)));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            b bVar = this.f36858e;
            if (bVar != null) {
                return (int) Math.round(getA() * Math.cos(Math.toRadians(bVar.f36862b)));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            b bVar = this.f36858e;
            if (bVar != null) {
                return bVar.f36863c;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getTenonHeigh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            b bVar = this.f36858e;
            if (bVar != null) {
                return bVar.a;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r();
            this.f36855b.setColor(SkinManager.getColor(R.color.CAM_X0210));
            invalidate();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f36859f = Math.max(getPaddingLeft(), getPaddingRight());
            this.f36860g = Math.max(getPaddingTop(), getPaddingBottom());
        }
    }

    public FrsAnomalyImg o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.f36857d = i;
            return this;
        }
        return (FrsAnomalyImg) invokeI.objValue;
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            n();
            this.p.reset();
            if (this.o != null) {
                float min = Math.min(this.f36861h / this.m, this.i / this.n);
                this.p.postScale(min, min);
                this.o.setLocalMatrix(this.p);
                this.a.setShader(this.o);
            } else {
                float f2 = (this.i / 2.0f) / this.k;
                this.p.postScale(f2, f2);
                this.p.postTranslate((this.f36861h - (this.j * f2)) / 2.0f, (this.i - (this.k * f2)) / 2.0f);
                this.l.setLocalMatrix(this.p);
                this.a.setShader(this.l);
            }
            this.f36856c.moveTo(this.f36859f, this.f36857d + this.f36860g);
            Path path = this.f36856c;
            int i = this.f36859f;
            int i2 = this.f36860g;
            path.quadTo(i, i2, this.f36857d + i, i2);
            this.f36856c.quadTo(this.f36857d + this.f36859f, this.f36860g, (getWidth() - this.f36857d) - this.f36859f, this.f36860g);
            this.f36856c.quadTo(getWidth() - this.f36859f, this.f36860g, getWidth() - this.f36859f, this.f36857d + this.f36860g);
            this.f36856c.quadTo(getWidth() - this.f36859f, this.f36857d + this.f36860g, getWidth() - this.f36859f, ((getHeight() - this.f36857d) - this.f36860g) - getTenonHeigh());
            this.f36856c.quadTo(getWidth() - this.f36859f, (getHeight() - this.f36860g) - getTenonHeigh(), (getWidth() - this.f36857d) - this.f36859f, (getHeight() - this.f36860g) - getTenonHeigh());
            this.f36856c.quadTo((getWidth() - this.f36857d) - this.f36859f, (getHeight() - this.f36860g) - getTenonHeigh(), getA() + getB() + getDistance(), (getHeight() - this.f36860g) - getTenonHeigh());
            this.f36856c.quadTo(getDistance() + getB(), (getHeight() - this.f36860g) - getTenonHeigh(), (getDistance() + getB()) - getC(), ((getHeight() - this.f36860g) - getTenonHeigh()) + getD());
            this.f36856c.quadTo((getDistance() + getB()) - getC(), ((getHeight() - this.f36860g) - getTenonHeigh()) + getD(), getDistance(), getHeight() - this.f36860g);
            this.f36856c.quadTo(getDistance(), getHeight() - this.f36860g, (getDistance() - getB()) + getC(), ((getHeight() - this.f36860g) - getTenonHeigh()) + getD());
            this.f36856c.quadTo(getDistance() - getB(), (getHeight() - this.f36860g) - getTenonHeigh(), (getDistance() - getB()) - getC(), (getHeight() - this.f36860g) - getTenonHeigh());
            this.f36856c.quadTo((getDistance() - getB()) - getC(), (getHeight() - this.f36860g) - getTenonHeigh(), this.f36859f + this.f36857d, (getHeight() - this.f36860g) - getTenonHeigh());
            this.f36856c.quadTo(this.f36859f, (getHeight() - this.f36860g) - getTenonHeigh(), this.f36859f, ((getHeight() - this.f36857d) - this.f36860g) - getTenonHeigh());
            this.f36856c.quadTo(this.f36859f, ((getHeight() - this.f36857d) - this.f36860g) - getTenonHeigh(), this.f36859f, this.f36857d + this.f36860g);
            this.f36856c.close();
            if (this.q) {
                canvas.drawPath(this.f36856c, this.f36855b);
                canvas.drawPath(this.f36856c, this.a);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.f36861h = getMeasuredWidth();
            int measuredWidth = (int) (getMeasuredWidth() * 0.21851853f);
            this.i = measuredWidth;
            setMeasuredDimension(this.f36861h, measuredWidth);
        }
    }

    public FrsAnomalyImg p(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.f36858e = bVar;
            return this;
        }
        return (FrsAnomalyImg) invokeL.objValue;
    }

    public void q(String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, bdUniqueId) == null) {
            d.h().k(str, 10, this.r, this.f36861h, this.i, bdUniqueId, new Object[0]);
        }
    }

    public final void r() {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08090d, SkinManager.getColor(R.color.CAM_X0112), WebPManager.ResourceStateType.NORMAL)) == null) {
            return;
        }
        this.k = pureDrawable.getIntrinsicHeight();
        this.j = pureDrawable.getIntrinsicWidth();
        Bitmap createBitmap = Bitmap.createBitmap(this.j, this.k, pureDrawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        pureDrawable.setBounds(0, 0, this.j, this.k);
        pureDrawable.draw(canvas);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.l = new BitmapShader(createBitmap, tileMode, tileMode);
    }

    public void setVisible(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bool) == null) {
            this.q = bool.booleanValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsAnomalyImg(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36857d = 0;
        this.f36858e = null;
        this.f36859f = 0;
        this.f36860g = 0;
        this.p = new Matrix();
        this.r = new a(this);
        this.a = new Paint();
        Paint paint = new Paint();
        this.f36855b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f36856c = new Path();
    }
}
