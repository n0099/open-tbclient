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
public class k42 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Stack<k42> a;
    public Paint b;
    public Paint c;
    public Paint d;
    public TextPaint e;
    public Path f;
    public boolean g;
    public CanvasView h;
    public t52 i;
    public int j;
    public int k;
    public int l;
    public int m;

    public k42(CanvasView canvasView) {
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
        t52 t52Var;
        r42 r42Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, paint) != null) || paint == null) {
            return;
        }
        if (this.h != null && (t52Var = this.i) != null && (r42Var = t52Var.d) != null && !r42Var.c()) {
            t52 t52Var2 = this.i;
            paint.setShadowLayer(t52Var2.c, t52Var2.a, t52Var2.b, t52Var2.d.a());
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
            this.c.setStrokeWidth(uo3.g(1.0f));
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
        k42 pop = this.a.pop();
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
            k42 k42Var = (k42) super.clone();
            k42Var.b = new Paint(this.b);
            k42Var.c = new Paint(this.c);
            k42Var.d = new Paint(this.d);
            k42Var.e = new TextPaint(this.e);
            k42Var.f = new Path(this.f);
            k42Var.k = this.k;
            k42Var.l = this.l;
            k42Var.m = this.m;
            this.a.push(k42Var);
        }
    }
}
