package com.baidu.tieba;

import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Stack;
/* loaded from: classes6.dex */
public class tw1 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Stack a;
    public Paint b;
    public Paint c;
    public Paint d;
    public TextPaint e;
    public Path f;
    public boolean g;
    public CanvasView h;
    public cy1 i;
    public int j;
    public int k;
    public int l;
    public int m;

    public tw1(CanvasView canvasView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {canvasView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Stack();
        this.b = new Paint();
        this.c = new Paint();
        this.d = new Paint();
        this.e = new TextPaint();
        this.f = new Path();
        this.g = false;
        this.j = -1;
        this.k = 0;
        this.l = 0;
        this.m = -16777216;
        this.h = canvasView;
        d();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.l = i;
        }
    }

    public void c(Paint paint) {
        cy1 cy1Var;
        ax1 ax1Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, paint) != null) || paint == null) {
            return;
        }
        if (this.h != null && (cy1Var = this.i) != null && (ax1Var = cy1Var.d) != null && !ax1Var.c()) {
            cy1 cy1Var2 = this.i;
            paint.setShadowLayer(cy1Var2.c, cy1Var2.a, cy1Var2.b, cy1Var2.d.a());
        }
        int i = this.j;
        if (i >= 0 && i <= 255) {
            paint.setAlpha(Math.min((paint.getAlpha() * this.j) >> 8, 255));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.m = -16777216;
            this.c.setStyle(Paint.Style.STROKE);
            this.b.setColor(-16777216);
            this.c.setColor(-16777216);
            this.d.setColor(-16777216);
            this.e.setColor(-16777216);
            this.c.setStrokeWidth(dh3.g(1.0f));
            this.c.setAntiAlias(true);
            this.e.setAntiAlias(true);
            this.d.setAntiAlias(true);
            this.f.reset();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a.empty()) {
            return;
        }
        tw1 tw1Var = (tw1) this.a.pop();
        this.b = tw1Var.b;
        this.c = tw1Var.c;
        this.d = tw1Var.d;
        this.e = tw1Var.e;
        this.f = tw1Var.f;
        this.g = tw1Var.g;
        this.a = tw1Var.a;
        this.i = tw1Var.i;
        this.j = tw1Var.j;
        this.k = tw1Var.k;
        this.l = tw1Var.l;
        this.m = tw1Var.m;
    }

    public void f() throws CloneNotSupportedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            tw1 tw1Var = (tw1) super.clone();
            tw1Var.b = new Paint(this.b);
            tw1Var.c = new Paint(this.c);
            tw1Var.d = new Paint(this.d);
            tw1Var.e = new TextPaint(this.e);
            tw1Var.f = new Path(this.f);
            tw1Var.k = this.k;
            tw1Var.l = this.l;
            tw1Var.m = this.m;
            this.a.push(tw1Var);
        }
    }
}
