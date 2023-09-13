package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
    }

    /* loaded from: classes8.dex */
    public class a extends BdResourceCallback<BdImage> {
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

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdImage, str, i) == null) && bdImage != null) {
                this.a.m = bdImage.getWidth();
                this.a.n = bdImage.getHeight();
                this.a.o = bdImage.createBitmapShader();
                this.a.invalidate();
            }
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
        new a(this);
        this.a = new Paint();
        Paint paint = new Paint();
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.c = new Path();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.h = getMeasuredWidth();
            int measuredWidth = (int) (getMeasuredWidth() * 0.21851853f);
            this.i = measuredWidth;
            setMeasuredDimension(this.h, measuredWidth);
        }
    }

    private int getA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            b bVar = this.e;
            if (bVar != null) {
                return bVar.a;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = Math.max(getPaddingLeft(), getPaddingRight());
            this.g = Math.max(getPaddingTop(), getPaddingBottom());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            B();
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

    public void setVisible(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
            this.q = bool.booleanValue();
        }
    }
}
