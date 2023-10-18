package com.baidu.tieba;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class z14 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static b24[] b;
    public static Point c;
    public static float d;
    public static float e;
    public static boolean f;
    public static int g;
    public static long h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948307084, "Lcom/baidu/tieba/z14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948307084, "Lcom/baidu/tieba/z14;");
                return;
            }
        }
        a = am1.a;
        c = new Point();
        d = 1.0f;
        e = 1.0f;
        f = false;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return h;
        }
        return invokeV.longValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return g;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return f;
        }
        return invokeV.booleanValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            g = 0;
        }
    }

    public static float d(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, motionEvent, i)) == null) {
            return f84.b(motionEvent.getX(i) * d);
        }
        return invokeLI.floatValue;
    }

    public static float e(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, motionEvent, i)) == null) {
            return f84.b(motionEvent.getY(i) * e);
        }
        return invokeLI.floatValue;
    }

    public static void l(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65548, null, i, i2) == null) {
            Point point = c;
            point.x = i;
            point.y = i2;
        }
    }

    public static boolean f(EventTarget eventTarget) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, eventTarget)) == null) {
            if (eventTarget == null) {
                return false;
            }
            return eventTarget.hasEventListener("touchstart", "touchmove", "touchcancel", "touchend");
        }
        return invokeL.booleanValue;
    }

    public static void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            f = z;
        }
    }

    public static void h(MotionEvent motionEvent, a24 a24Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65544, null, motionEvent, a24Var, z) == null) {
            try {
                if (!z) {
                    int actionIndex = motionEvent.getActionIndex();
                    a24Var.changedTouches = r1;
                    b24[] b24VarArr = {new b24()};
                    a24Var.changedTouches[0].identifier = motionEvent.getPointerId(actionIndex);
                    a24Var.changedTouches[0].clientX = d(motionEvent, actionIndex);
                    a24Var.changedTouches[0].clientY = e(motionEvent, actionIndex);
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                if (b == null || b.length != pointerCount) {
                    b = new b24[pointerCount];
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < pointerCount; i++) {
                    b24 b24Var = new b24();
                    b24Var.identifier = motionEvent.getPointerId(i);
                    b24Var.clientX = d(motionEvent, i);
                    b24Var.clientY = e(motionEvent, i);
                    if (!b24Var.equals(b[i])) {
                        arrayList.add(b24Var);
                    }
                    b[i] = b24Var;
                }
                if (arrayList.size() != 0) {
                    b24[] b24VarArr2 = new b24[arrayList.size()];
                    a24Var.changedTouches = b24VarArr2;
                    arrayList.toArray(b24VarArr2);
                }
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
        if (r8.getActionIndex() != r3) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(MotionEvent motionEvent, a24 a24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, motionEvent, a24Var) == null) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < pointerCount) {
                    int actionMasked = motionEvent.getActionMasked();
                    boolean z = true;
                    if (actionMasked != 6 && actionMasked != 1 && actionMasked != 3) {
                        z = false;
                    }
                    int pointerId = motionEvent.getPointerId(i);
                    b24 b24Var = new b24();
                    b24Var.identifier = pointerId;
                    b24Var.clientX = d(motionEvent, i);
                    b24Var.clientY = e(motionEvent, i);
                    arrayList.add(b24Var);
                    i++;
                }
                a24Var.touches = new b24[arrayList.size()];
                if (!arrayList.isEmpty()) {
                    arrayList.toArray(a24Var.touches);
                }
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static JSEvent j(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, motionEvent)) == null) {
            a24 a24Var = new a24();
            int actionMasked = motionEvent.getActionMasked();
            String str = "touchend";
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked != 5) {
                                if (actionMasked != 6) {
                                    str = "toucherror";
                                } else {
                                    h(motionEvent, a24Var, false);
                                }
                            } else {
                                h(motionEvent, a24Var, false);
                            }
                        } else {
                            h(motionEvent, a24Var, false);
                            str = "touchcancel";
                        }
                    } else {
                        h(motionEvent, a24Var, true);
                        str = "touchmove";
                    }
                } else {
                    h(motionEvent, a24Var, false);
                }
                a24Var.timeStamp = motionEvent.getEventTime();
                i(motionEvent, a24Var);
                JSEvent jSEvent = new JSEvent(str);
                jSEvent.data = a24Var;
                if (!"touchmove".equals(str) && a24Var.changedTouches == null) {
                    return null;
                }
            }
            h(motionEvent, a24Var, false);
            int i = g + 1;
            g = i;
            g = Math.min(i, 1000);
            h = System.currentTimeMillis();
            str = "touchstart";
            a24Var.timeStamp = motionEvent.getEventTime();
            i(motionEvent, a24Var);
            JSEvent jSEvent2 = new JSEvent(str);
            jSEvent2.data = a24Var;
            return !"touchmove".equals(str) ? jSEvent2 : jSEvent2;
        }
        return (JSEvent) invokeL.objValue;
    }

    public static void m(int i, int i2) {
        float f2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65549, null, i, i2) == null) {
            float f3 = 1.0f;
            if (i != 0 && (i4 = c.x) != 0) {
                f2 = i4 / i;
            } else {
                f2 = 1.0f;
            }
            d = f2;
            if (i2 != 0 && (i3 = c.y) != 0) {
                f3 = i3 / i2;
            }
            e = f3;
            if (a) {
                Log.i("SwanGameTouchHelper", String.format("setSurfaceViewCurrentSize:%f,%f", Float.valueOf(d), Float.valueOf(e)));
            }
        }
    }
}
