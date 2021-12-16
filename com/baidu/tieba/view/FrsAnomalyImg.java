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
/* loaded from: classes12.dex */
public class FrsAnomalyImg extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f50773e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f50774f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f50775g;

    /* renamed from: h  reason: collision with root package name */
    public int f50776h;

    /* renamed from: i  reason: collision with root package name */
    public b f50777i;

    /* renamed from: j  reason: collision with root package name */
    public int f50778j;

    /* renamed from: k  reason: collision with root package name */
    public int f50779k;
    public int l;
    public int m;
    public final c<c.a.d.m.d.a> mCallback;
    public int n;
    public int o;
    public Shader p;
    public int q;
    public int r;
    public Shader s;
    public final Matrix t;
    public boolean u;

    /* loaded from: classes12.dex */
    public class a extends c<c.a.d.m.d.a> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void onLoaded(c.a.d.m.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            this.a.q = aVar.r();
            this.a.r = aVar.m();
            this.a.s = aVar.d();
            this.a.invalidate();
        }
    }

    /* loaded from: classes12.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f50780b;

        /* renamed from: c  reason: collision with root package name */
        public int f50781c;

        /* renamed from: d  reason: collision with root package name */
        public int f50782d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public b a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f50780b = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f50781c = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f50782d = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.a = i2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            b bVar = this.f50777i;
            if (bVar != null) {
                return (int) Math.round(this.f50777i.f50782d / Math.tan(Math.toRadians((int) (((bVar.f50780b + 90) / 2) + 0.5d))));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            b bVar = this.f50777i;
            if (bVar != null) {
                return (int) Math.round(this.f50777i.a * Math.tan(Math.toRadians(bVar.f50780b)));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            b bVar = this.f50777i;
            if (bVar != null) {
                return (int) Math.round(getA() * Math.sin(Math.toRadians(bVar.f50780b)));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            b bVar = this.f50777i;
            if (bVar != null) {
                return (int) Math.round(getA() * Math.cos(Math.toRadians(bVar.f50780b)));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            b bVar = this.f50777i;
            if (bVar != null) {
                return bVar.f50781c;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getTenonHeigh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            b bVar = this.f50777i;
            if (bVar != null) {
                return bVar.a;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
            this.f50774f.setColor(SkinManager.getColor(R.color.CAM_X0210));
            invalidate();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f50778j = Math.max(getPaddingLeft(), getPaddingRight());
            this.f50779k = Math.max(getPaddingTop(), getPaddingBottom());
        }
    }

    public final void i() {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_header40_n, SkinManager.getColor(R.color.CAM_X0112), WebPManager.ResourceStateType.NORMAL)) == null) {
            return;
        }
        this.o = pureDrawable.getIntrinsicHeight();
        this.n = pureDrawable.getIntrinsicWidth();
        Bitmap createBitmap = Bitmap.createBitmap(this.n, this.o, pureDrawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        pureDrawable.setBounds(0, 0, this.n, this.o);
        pureDrawable.draw(canvas);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.p = new BitmapShader(createBitmap, tileMode, tileMode);
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            h();
            this.t.reset();
            if (this.s != null) {
                float min = Math.min(this.l / this.q, this.m / this.r);
                this.t.postScale(min, min);
                this.s.setLocalMatrix(this.t);
                this.f50773e.setShader(this.s);
            } else {
                float f2 = (this.m / 2.0f) / this.o;
                this.t.postScale(f2, f2);
                this.t.postTranslate((this.l - (this.n * f2)) / 2.0f, (this.m - (this.o * f2)) / 2.0f);
                this.p.setLocalMatrix(this.t);
                this.f50773e.setShader(this.p);
            }
            this.f50775g.moveTo(this.f50778j, this.f50776h + this.f50779k);
            Path path = this.f50775g;
            int i2 = this.f50778j;
            int i3 = this.f50779k;
            path.quadTo(i2, i3, this.f50776h + i2, i3);
            this.f50775g.quadTo(this.f50776h + this.f50778j, this.f50779k, (getWidth() - this.f50776h) - this.f50778j, this.f50779k);
            this.f50775g.quadTo(getWidth() - this.f50778j, this.f50779k, getWidth() - this.f50778j, this.f50776h + this.f50779k);
            this.f50775g.quadTo(getWidth() - this.f50778j, this.f50776h + this.f50779k, getWidth() - this.f50778j, ((getHeight() - this.f50776h) - this.f50779k) - getTenonHeigh());
            this.f50775g.quadTo(getWidth() - this.f50778j, (getHeight() - this.f50779k) - getTenonHeigh(), (getWidth() - this.f50776h) - this.f50778j, (getHeight() - this.f50779k) - getTenonHeigh());
            this.f50775g.quadTo((getWidth() - this.f50776h) - this.f50778j, (getHeight() - this.f50779k) - getTenonHeigh(), getA() + getB() + getDistance(), (getHeight() - this.f50779k) - getTenonHeigh());
            this.f50775g.quadTo(getDistance() + getB(), (getHeight() - this.f50779k) - getTenonHeigh(), (getDistance() + getB()) - getC(), ((getHeight() - this.f50779k) - getTenonHeigh()) + getD());
            this.f50775g.quadTo((getDistance() + getB()) - getC(), ((getHeight() - this.f50779k) - getTenonHeigh()) + getD(), getDistance(), getHeight() - this.f50779k);
            this.f50775g.quadTo(getDistance(), getHeight() - this.f50779k, (getDistance() - getB()) + getC(), ((getHeight() - this.f50779k) - getTenonHeigh()) + getD());
            this.f50775g.quadTo(getDistance() - getB(), (getHeight() - this.f50779k) - getTenonHeigh(), (getDistance() - getB()) - getC(), (getHeight() - this.f50779k) - getTenonHeigh());
            this.f50775g.quadTo((getDistance() - getB()) - getC(), (getHeight() - this.f50779k) - getTenonHeigh(), this.f50778j + this.f50776h, (getHeight() - this.f50779k) - getTenonHeigh());
            this.f50775g.quadTo(this.f50778j, (getHeight() - this.f50779k) - getTenonHeigh(), this.f50778j, ((getHeight() - this.f50776h) - this.f50779k) - getTenonHeigh());
            this.f50775g.quadTo(this.f50778j, ((getHeight() - this.f50776h) - this.f50779k) - getTenonHeigh(), this.f50778j, this.f50776h + this.f50779k);
            this.f50775g.close();
            if (this.u) {
                canvas.drawPath(this.f50775g, this.f50774f);
                canvas.drawPath(this.f50775g, this.f50773e);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.l = getMeasuredWidth();
            int measuredWidth = (int) (getMeasuredWidth() * 0.21851853f);
            this.m = measuredWidth;
            setMeasuredDimension(this.l, measuredWidth);
        }
    }

    public FrsAnomalyImg setCorner(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f50776h = i2;
            return this;
        }
        return (FrsAnomalyImg) invokeI.objValue;
    }

    public FrsAnomalyImg setTenon(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
            this.f50777i = bVar;
            return this;
        }
        return (FrsAnomalyImg) invokeL.objValue;
    }

    public void setVisible(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bool) == null) {
            this.u = bool.booleanValue();
        }
    }

    public void startLoad(String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bdUniqueId) == null) {
            d.h().k(str, 10, this.mCallback, this.l, this.m, bdUniqueId, new Object[0]);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50776h = 0;
        this.f50777i = null;
        this.f50778j = 0;
        this.f50779k = 0;
        this.t = new Matrix();
        this.mCallback = new a(this);
        this.f50773e = new Paint();
        Paint paint = new Paint();
        this.f50774f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f50775g = new Path();
    }
}
