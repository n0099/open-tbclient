package com.baidu.tieba;

import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.f3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class v2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public v2() {
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

    public boolean a(MotionEvent motionEvent, f3 f3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, motionEvent, f3Var)) == null) {
            if ((motionEvent.getSource() & 2) == 0) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            long nanoTime = System.nanoTime();
            synchronized (f3Var) {
                if (action != 7) {
                    if (action == 8) {
                        b(f3Var, 3, 0, 0, (int) (-Math.signum(motionEvent.getAxisValue(10))), (int) (-Math.signum(motionEvent.getAxisValue(9))), nanoTime);
                    }
                } else {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x != this.a || y != this.b) {
                        b(f3Var, 4, x, y, 0, 0, nanoTime);
                        this.a = x;
                        this.b = y;
                    }
                }
            }
            f1.a.getGraphics().c();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void b(f3 f3Var, int i, int i2, int i3, int i4, int i5, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{f3Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j)}) == null) {
            f3.f fVar = (f3.f) f3Var.g.e();
            fVar.a = j;
            fVar.c = i2;
            fVar.d = i3;
            fVar.b = i;
            fVar.e = i4;
            fVar.f = i5;
            f3Var.j.add(fVar);
        }
    }
}
