package com.baidu.tieba;

import android.content.Context;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.y2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i == 0 || i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 8) {
                return 3;
            }
            return i == 16 ? 4 : -1;
        }
        return invokeI.intValue;
    }

    public t2() {
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

    public void a(MotionEvent motionEvent, y2 y2Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, motionEvent, y2Var) == null) {
            int action = motionEvent.getAction() & 255;
            int action2 = (motionEvent.getAction() & 65280) >> 8;
            int pointerId = motionEvent.getPointerId(action2);
            long nanoTime = System.nanoTime();
            synchronized (y2Var) {
                int i9 = 20;
                boolean z = false;
                switch (action) {
                    case 0:
                    case 5:
                        int d = y2Var.d();
                        if (d >= 20) {
                            break;
                        } else {
                            y2Var.q[d] = pointerId;
                            int x = (int) motionEvent.getX(action2);
                            int y = (int) motionEvent.getY(action2);
                            int d2 = d(motionEvent.getButtonState());
                            if (d2 != -1) {
                                i = d2;
                                i2 = x;
                                i3 = y;
                                b(y2Var, 0, x, y, d, i, nanoTime);
                            } else {
                                i = d2;
                                i2 = x;
                                i3 = y;
                            }
                            y2Var.k[d] = i2;
                            y2Var.l[d] = i3;
                            y2Var.m[d] = 0;
                            y2Var.n[d] = 0;
                            boolean[] zArr = y2Var.o;
                            int i10 = i;
                            if (i10 != -1) {
                                z = true;
                            }
                            zArr[d] = z;
                            y2Var.p[d] = i10;
                            y2Var.r[d] = motionEvent.getPressure(action2);
                            break;
                        }
                    case 1:
                    case 4:
                    case 6:
                        int f = y2Var.f(pointerId);
                        if (f != -1 && f < 20) {
                            y2Var.q[f] = -1;
                            int x2 = (int) motionEvent.getX(action2);
                            int y2 = (int) motionEvent.getY(action2);
                            int i11 = y2Var.p[f];
                            if (i11 != -1) {
                                i4 = x2;
                                b(y2Var, 1, x2, y2, f, i11, nanoTime);
                            } else {
                                i4 = x2;
                            }
                            y2Var.k[f] = i4;
                            y2Var.l[f] = y2;
                            y2Var.m[f] = 0;
                            y2Var.n[f] = 0;
                            y2Var.o[f] = false;
                            y2Var.p[f] = 0;
                            y2Var.r[f] = 0.0f;
                            break;
                        }
                        break;
                    case 2:
                        int pointerCount = motionEvent.getPointerCount();
                        int i12 = 0;
                        while (i12 < pointerCount) {
                            int pointerId2 = motionEvent.getPointerId(i12);
                            int x3 = (int) motionEvent.getX(i12);
                            int y3 = (int) motionEvent.getY(i12);
                            int f2 = y2Var.f(pointerId2);
                            if (f2 == -1) {
                                i7 = i12;
                            } else if (f2 >= i9) {
                                break;
                            } else {
                                int i13 = y2Var.p[f2];
                                if (i13 != -1) {
                                    i5 = f2;
                                    i6 = y3;
                                    i7 = i12;
                                    i8 = x3;
                                    b(y2Var, 2, x3, y3, f2, i13, nanoTime);
                                } else {
                                    i5 = f2;
                                    i6 = y3;
                                    i7 = i12;
                                    i8 = x3;
                                    b(y2Var, 4, i8, i6, f2, 0, nanoTime);
                                }
                                y2Var.m[i5] = i8 - y2Var.k[i5];
                                y2Var.n[i5] = i6 - y2Var.l[i5];
                                y2Var.k[i5] = i8;
                                y2Var.l[i5] = i6;
                                y2Var.r[i5] = motionEvent.getPressure(i7);
                            }
                            i12 = i7 + 1;
                            i9 = 20;
                        }
                        break;
                    case 3:
                        for (int i14 = 0; i14 < y2Var.q.length; i14++) {
                            y2Var.q[i14] = -1;
                            y2Var.k[i14] = 0;
                            y2Var.l[i14] = 0;
                            y2Var.m[i14] = 0;
                            y2Var.n[i14] = 0;
                            y2Var.o[i14] = false;
                            y2Var.p[i14] = 0;
                            y2Var.r[i14] = 0.0f;
                        }
                        break;
                }
            }
            y0.a.getGraphics().c();
        }
    }

    public final void b(y2 y2Var, int i, int i2, int i3, int i4, int i5, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{y2Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j)}) == null) {
            y2.f e = y2Var.g.e();
            e.a = j;
            e.h = i4;
            e.c = i2;
            e.d = i3;
            e.b = i;
            e.g = i5;
            y2Var.j.add(e);
        }
    }

    public boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            return context.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch");
        }
        return invokeL.booleanValue;
    }
}
