package com.baidu.tieba;

import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class n2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public n2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0;
    }

    public boolean a(MotionEvent motionEvent, x2 x2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, motionEvent, x2Var)) == null) {
            if ((motionEvent.getSource() & 2) == 0) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            long nanoTime = System.nanoTime();
            synchronized (x2Var) {
                if (action != 7) {
                    if (action == 8) {
                        b(x2Var, 3, 0, 0, (int) (-Math.signum(motionEvent.getAxisValue(10))), (int) (-Math.signum(motionEvent.getAxisValue(9))), nanoTime);
                    }
                } else {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x != this.a || y != this.b) {
                        b(x2Var, 4, x, y, 0, 0, nanoTime);
                        this.a = x;
                        this.b = y;
                    }
                }
            }
            x0.a.getGraphics().c();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void b(x2 x2Var, int i, int i2, int i3, int i4, int i5, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{x2Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j)}) == null) {
            x2.f e = x2Var.g.e();
            e.a = j;
            e.c = i2;
            e.d = i3;
            e.b = i;
            e.e = i4;
            e.f = i5;
            x2Var.j.add(e);
        }
    }
}
