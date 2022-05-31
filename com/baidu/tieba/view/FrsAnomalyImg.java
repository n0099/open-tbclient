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
import com.repackage.eg;
import com.repackage.fg;
import com.repackage.um;
/* loaded from: classes4.dex */
public class FrsAnomalyImg extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint a;
    public final Paint b;
    public final Path c;
    public int d;
    public b e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public Shader l;
    public int m;
    public int n;
    public Shader o;
    public final Matrix p;
    public boolean q;
    public final eg<um> r;

    /* loaded from: classes4.dex */
    public class a extends eg<um> {
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

        @Override // com.repackage.eg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.repackage.eg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        public void onLoaded(um umVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, umVar, str, i) == null) || umVar == null) {
                return;
            }
            this.a.m = umVar.r();
            this.a.n = umVar.m();
            this.a.o = umVar.d();
            this.a.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;

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
                this.b = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.c = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.d = i;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            b bVar = this.e;
            if (bVar != null) {
                return (int) Math.round(this.e.d / Math.tan(Math.toRadians((int) (((bVar.b + 90) / 2) + 0.5d))));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            b bVar = this.e;
            if (bVar != null) {
                return (int) Math.round(this.e.a * Math.tan(Math.toRadians(bVar.b)));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            b bVar = this.e;
            if (bVar != null) {
                return (int) Math.round(getA() * Math.sin(Math.toRadians(bVar.b)));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            b bVar = this.e;
            if (bVar != null) {
                return (int) Math.round(getA() * Math.cos(Math.toRadians(bVar.b)));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            b bVar = this.e;
            if (bVar != null) {
                return bVar.c;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getTenonHeigh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            b bVar = this.e;
            if (bVar != null) {
                return bVar.a;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            r();
            this.p.reset();
            if (this.o != null) {
                float min = Math.min(this.h / this.m, this.i / this.n);
                this.p.postScale(min, min);
                this.o.setLocalMatrix(this.p);
                this.a.setShader(this.o);
            } else {
                float f = (this.i / 2.0f) / this.k;
                this.p.postScale(f, f);
                this.p.postTranslate((this.h - (this.j * f)) / 2.0f, (this.i - (this.k * f)) / 2.0f);
                this.l.setLocalMatrix(this.p);
                this.a.setShader(this.l);
            }
            this.c.moveTo(this.f, this.d + this.g);
            Path path = this.c;
            int i = this.f;
            int i2 = this.g;
            path.quadTo(i, i2, this.d + i, i2);
            this.c.quadTo(this.d + this.f, this.g, (getWidth() - this.d) - this.f, this.g);
            this.c.quadTo(getWidth() - this.f, this.g, getWidth() - this.f, this.d + this.g);
            this.c.quadTo(getWidth() - this.f, this.d + this.g, getWidth() - this.f, ((getHeight() - this.d) - this.g) - getTenonHeigh());
            this.c.quadTo(getWidth() - this.f, (getHeight() - this.g) - getTenonHeigh(), (getWidth() - this.d) - this.f, (getHeight() - this.g) - getTenonHeigh());
            this.c.quadTo((getWidth() - this.d) - this.f, (getHeight() - this.g) - getTenonHeigh(), getA() + getB() + getDistance(), (getHeight() - this.g) - getTenonHeigh());
            this.c.quadTo(getDistance() + getB(), (getHeight() - this.g) - getTenonHeigh(), (getDistance() + getB()) - getC(), ((getHeight() - this.g) - getTenonHeigh()) + getD());
            this.c.quadTo((getDistance() + getB()) - getC(), ((getHeight() - this.g) - getTenonHeigh()) + getD(), getDistance(), getHeight() - this.g);
            this.c.quadTo(getDistance(), getHeight() - this.g, (getDistance() - getB()) + getC(), ((getHeight() - this.g) - getTenonHeigh()) + getD());
            this.c.quadTo(getDistance() - getB(), (getHeight() - this.g) - getTenonHeigh(), (getDistance() - getB()) - getC(), (getHeight() - this.g) - getTenonHeigh());
            this.c.quadTo((getDistance() - getB()) - getC(), (getHeight() - this.g) - getTenonHeigh(), this.f + this.d, (getHeight() - this.g) - getTenonHeigh());
            this.c.quadTo(this.f, (getHeight() - this.g) - getTenonHeigh(), this.f, ((getHeight() - this.d) - this.g) - getTenonHeigh());
            this.c.quadTo(this.f, ((getHeight() - this.d) - this.g) - getTenonHeigh(), this.f, this.d + this.g);
            this.c.close();
            if (this.q) {
                canvas.drawPath(this.c, this.b);
                canvas.drawPath(this.c, this.a);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.h = getMeasuredWidth();
            int measuredWidth = (int) (getMeasuredWidth() * 0.21851853f);
            this.i = measuredWidth;
            setMeasuredDimension(this.h, measuredWidth);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            v();
            this.b.setColor(SkinManager.getColor(R.color.CAM_X0210));
            invalidate();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f = Math.max(getPaddingLeft(), getPaddingRight());
            this.g = Math.max(getPaddingTop(), getPaddingBottom());
        }
    }

    public FrsAnomalyImg s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.d = i;
            return this;
        }
        return (FrsAnomalyImg) invokeI.objValue;
    }

    public void setVisible(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bool) == null) {
            this.q = bool.booleanValue();
        }
    }

    public FrsAnomalyImg t(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
            this.e = bVar;
            return this;
        }
        return (FrsAnomalyImg) invokeL.objValue;
    }

    public void u(String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, bdUniqueId) == null) {
            fg.h().k(str, 10, this.r, this.h, this.i, bdUniqueId, new Object[0]);
        }
    }

    public final void v() {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080931, SkinManager.getColor(R.color.CAM_X0112), WebPManager.ResourceStateType.NORMAL)) == null) {
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
        this.d = 0;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.p = new Matrix();
        this.r = new a(this);
        this.a = new Paint();
        Paint paint = new Paint();
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.c = new Path();
    }
}
