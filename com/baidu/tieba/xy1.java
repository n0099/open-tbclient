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
/* loaded from: classes8.dex */
public class xy1 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Stack<xy1> a;
    public Paint b;
    public Paint c;
    public Paint d;
    public TextPaint e;
    public Path f;
    public boolean g;
    public CanvasView h;
    public g02 i;
    public int j;
    public int k;
    public int l;
    public int m;

    public xy1(CanvasView canvasView) {
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
        this.a = new Stack<>();
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
        g02 g02Var;
        ez1 ez1Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, paint) != null) || paint == null) {
            return;
        }
        if (this.h != null && (g02Var = this.i) != null && (ez1Var = g02Var.d) != null && !ez1Var.c()) {
            g02 g02Var2 = this.i;
            paint.setShadowLayer(g02Var2.c, g02Var2.a, g02Var2.b, g02Var2.d.a());
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
            this.c.setStrokeWidth(gj3.g(1.0f));
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
        xy1 pop = this.a.pop();
        this.b = pop.b;
        this.c = pop.c;
        this.d = pop.d;
        this.e = pop.e;
        this.f = pop.f;
        this.g = pop.g;
        this.a = pop.a;
        this.i = pop.i;
        this.j = pop.j;
        this.k = pop.k;
        this.l = pop.l;
        this.m = pop.m;
    }

    public void f() throws CloneNotSupportedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            xy1 xy1Var = (xy1) super.clone();
            xy1Var.b = new Paint(this.b);
            xy1Var.c = new Paint(this.c);
            xy1Var.d = new Paint(this.d);
            xy1Var.e = new TextPaint(this.e);
            xy1Var.f = new Path(this.f);
            xy1Var.k = this.k;
            xy1Var.l = this.l;
            xy1Var.m = this.m;
            this.a.push(xy1Var);
        }
    }
}
