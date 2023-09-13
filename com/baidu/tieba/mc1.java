package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.widget.ScrollerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class mc1 {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator w;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public float m;
    public float n;
    public int o;
    public int p;
    public ScrollerCompat q;
    public final c r;
    public View s;
    public boolean t;
    public final ViewGroup u;
    public final Runnable v;

    /* loaded from: classes7.dex */
    public class a implements Interpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
            return invokeF.floatValue;
        }

        public a() {
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
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc1 a;

        public b(mc1 mc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mc1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.G(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract int a(View view2, int i, int i2);

        public int b(View view2, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, i2)) == null) {
                return 0;
            }
            return invokeLII.intValue;
        }

        public int c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i : invokeI.intValue;
        }

        public abstract int d(View view2);

        public int e(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        public abstract boolean f();

        public abstract void g(int i, int i2);

        public boolean h(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        public void i(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            }
        }

        public abstract void j(View view2, int i);

        public abstract void k(int i);

        public abstract void l(View view2, int i, int i2, int i3, int i4);

        public abstract void m(View view2, float f, float f2);

        public abstract boolean n(View view2, int i);

        public c() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947967758, "Lcom/baidu/tieba/mc1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947967758, "Lcom/baidu/tieba/mc1;");
                return;
            }
        }
        w = new a();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.c = -1;
            h();
            VelocityTracker velocityTracker = this.l;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.l = null;
            }
        }
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public mc1(Context context, ViewGroup viewGroup, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.v = new b(this);
        if (viewGroup != null) {
            if (cVar != null) {
                this.u = viewGroup;
                this.r = cVar;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
                this.b = viewConfiguration.getScaledTouchSlop();
                this.m = viewConfiguration.getScaledMaximumFlingVelocity();
                this.n = viewConfiguration.getScaledMinimumFlingVelocity();
                this.q = ScrollerCompat.create(context, w);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public final boolean e(View view2, float f, float f2) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (view2 == null) {
                return false;
            }
            if (this.r.d(view2) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (this.r.e(view2) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && z2) {
                int i = this.b;
                if ((f * f) + (f2 * f2) <= i * i) {
                    return false;
                }
                return true;
            } else if (z) {
                if (Math.abs(f) <= this.b) {
                    return false;
                }
                return true;
            } else if (!z2 || Math.abs(f2) <= this.b) {
                return false;
            } else {
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static mc1 m(ViewGroup viewGroup, float f, c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{viewGroup, Float.valueOf(f), cVar})) == null) {
            mc1 n = n(viewGroup, cVar);
            n.b = (int) (n.b * (1.0f / f));
            return n;
        }
        return (mc1) invokeCommon.objValue;
    }

    public final float f(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float abs = Math.abs(f);
            if (abs < f2) {
                return 0.0f;
            }
            if (abs > f3) {
                if (f <= 0.0f) {
                    return -f3;
                }
                return f3;
            }
            return f;
        }
        return invokeCommon.floatValue;
    }

    public static mc1 n(ViewGroup viewGroup, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, viewGroup, cVar)) == null) {
            return new mc1(viewGroup.getContext(), viewGroup, cVar);
        }
        return (mc1) invokeLL.objValue;
    }

    public boolean M(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, view2, i)) == null) {
            if (view2 == this.s && this.c == i) {
                return true;
            }
            if (view2 != null && this.r.n(view2, i)) {
                this.c = i;
                c(view2, i);
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final float v(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, motionEvent, i)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
            if (findPointerIndex < 0) {
                return -1.0f;
            }
            return MotionEventCompat.getX(motionEvent, findPointerIndex);
        }
        return invokeLI.floatValue;
    }

    public final float w(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048609, this, motionEvent, i)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
            if (findPointerIndex < 0) {
                return -1.0f;
            }
            return MotionEventCompat.getY(motionEvent, findPointerIndex);
        }
        return invokeLI.floatValue;
    }

    public boolean z(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048612, this, i, i2)) == null) {
            return A(this.s, i, i2);
        }
        return invokeII.booleanValue;
    }

    public boolean A(View view2, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, view2, i, i2)) == null) {
            if (view2 == null || i < view2.getLeft() || i >= view2.getRight() || i2 < view2.getTop() || i2 >= view2.getBottom()) {
                return false;
            }
            return true;
        }
        return invokeLII.booleanValue;
    }

    public boolean L(View view2, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, view2, i, i2)) == null) {
            this.s = view2;
            this.c = -1;
            boolean t = t(i, i2, 0, 0);
            if (!t && this.a == 0 && this.s != null) {
                this.s = null;
            }
            return t;
        }
        return invokeLII.booleanValue;
    }

    public final int g(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048595, this, i, i2, i3)) == null) {
            int abs = Math.abs(i);
            if (abs < i2) {
                return 0;
            }
            if (abs > i3) {
                if (i <= 0) {
                    return -i3;
                }
                return i3;
            }
            return i;
        }
        return invokeIII.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x007b, code lost:
        if (r11 != (-1)) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007d, code lost:
        C();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void B(MotionEvent motionEvent) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (actionMasked == 0) {
                b();
            }
            if (this.l == null) {
                this.l = VelocityTracker.obtain();
            }
            this.l.addMovement(motionEvent);
            int i2 = 0;
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked != 5) {
                                if (actionMasked == 6) {
                                    int pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                                    if (this.a == 1 && pointerId == this.c) {
                                        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                                        while (true) {
                                            if (i2 < pointerCount) {
                                                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i2);
                                                if (pointerId2 != this.c) {
                                                    float v = v(motionEvent, i2);
                                                    float w2 = w(motionEvent, i2);
                                                    if (v == -1.0f || w2 == -1.0f) {
                                                        return;
                                                    }
                                                    View s = s((int) v, (int) w2);
                                                    View view2 = this.s;
                                                    if (s == view2 && M(view2, pointerId2)) {
                                                        i = this.c;
                                                        break;
                                                    }
                                                }
                                                i2++;
                                            } else {
                                                i = -1;
                                                break;
                                            }
                                        }
                                    }
                                    i(pointerId);
                                    return;
                                }
                                return;
                            }
                            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                            float v2 = v(motionEvent, actionIndex);
                            float w3 = w(motionEvent, actionIndex);
                            if (v2 == -1.0f || w3 == -1.0f) {
                                return;
                            }
                            E(v2, w3, pointerId3);
                            if (this.a == 0) {
                                M(s((int) v2, (int) w3), pointerId3);
                                int i3 = this.h[pointerId3];
                                int i4 = this.p;
                                if ((i3 & i4) != 0) {
                                    this.r.i(i3 & i4, pointerId3);
                                    return;
                                }
                                return;
                            } else if (z((int) v2, (int) w3)) {
                                M(this.s, pointerId3);
                                return;
                            } else {
                                return;
                            }
                        }
                        if (this.a == 1) {
                            o(0.0f, 0.0f);
                        }
                        b();
                        return;
                    } else if (this.a == 1) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.c);
                        float v3 = v(motionEvent, findPointerIndex);
                        float w4 = w(motionEvent, findPointerIndex);
                        if (v3 == -1.0f || w4 == -1.0f) {
                            return;
                        }
                        float[] fArr = this.f;
                        int i5 = this.c;
                        int i6 = (int) (v3 - fArr[i5]);
                        int i7 = (int) (w4 - this.g[i5]);
                        q(this.s.getLeft() + i6, this.s.getTop() + i7, i6, i7);
                        F(motionEvent);
                        return;
                    } else {
                        int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
                        while (i2 < pointerCount2) {
                            int pointerId4 = MotionEventCompat.getPointerId(motionEvent, i2);
                            float v4 = v(motionEvent, i2);
                            float w5 = w(motionEvent, i2);
                            if (v4 == -1.0f || w5 == -1.0f) {
                                return;
                            }
                            float f = v4 - this.d[pointerId4];
                            float f2 = w5 - this.e[pointerId4];
                            D(f, f2, pointerId4);
                            if (this.a != 1) {
                                View s2 = s((int) v4, (int) w5);
                                if (e(s2, f, f2) && M(s2, pointerId4)) {
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                        F(motionEvent);
                        return;
                    }
                }
                if (this.a == 1) {
                    C();
                }
                b();
                return;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId5 = MotionEventCompat.getPointerId(motionEvent, 0);
            View s3 = s((int) x, (int) y);
            E(x, y, pointerId5);
            M(s3, pointerId5);
            int i8 = this.h[pointerId5];
            int i9 = this.p;
            if ((i8 & i9) != 0) {
                this.r.i(i8 & i9, pointerId5);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l.computeCurrentVelocity(1000, this.m);
            o(f(VelocityTrackerCompat.getXVelocity(this.l, this.c), this.n, this.m), f(VelocityTrackerCompat.getYVelocity(this.l, this.c), this.n, this.m));
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b();
            if (this.a == 2) {
                int currX = this.q.getCurrX();
                int currY = this.q.getCurrY();
                this.q.abortAnimation();
                int currX2 = this.q.getCurrX();
                int currY2 = this.q.getCurrY();
                this.r.l(this.s, currX2, currY2, currX2 - currX, currY2 - currY);
            }
            G(0);
        }
    }

    public final void h() {
        float[] fArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (fArr = this.d) == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    public final void D(float f, float f2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i)}) == null) {
            int i2 = 1;
            if (!d(f, f2, i, 1)) {
                i2 = 0;
            }
            if (d(f2, f, i, 4)) {
                i2 |= 4;
            }
            if (d(f, f2, i, 2)) {
                i2 |= 2;
            }
            if (d(f2, f, i, 8)) {
                i2 |= 8;
            }
            if (i2 != 0) {
                int[] iArr = this.i;
                iArr[i] = iArr[i] | i2;
                this.r.g(i2, i);
            }
        }
    }

    public final void E(float f, float f2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i)}) == null) {
            r(i);
            float[] fArr = this.d;
            this.f[i] = f;
            fArr[i] = f;
            float[] fArr2 = this.e;
            this.g[i] = f2;
            fArr2[i] = f2;
            this.h[i] = u((int) f, (int) f2);
            this.k |= 1 << i;
        }
    }

    public final int j(int i, int i2, int i3) {
        InterceptResult invokeIII;
        int abs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048598, this, i, i2, i3)) == null) {
            if (i == 0) {
                return 0;
            }
            int width = this.u.getWidth();
            float f = width / 2;
            float p = f + (p(Math.min(1.0f, Math.abs(i) / width)) * f);
            int abs2 = Math.abs(i2);
            if (abs2 > 0) {
                abs = Math.round(Math.abs(p / abs2) * 1000.0f) * 4;
            } else {
                abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
            }
            return Math.min(abs, 600);
        }
        return invokeIII.intValue;
    }

    public final void F(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) {
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            for (int i = 0; i < pointerCount; i++) {
                int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
                float v = v(motionEvent, i);
                float w2 = w(motionEvent, i);
                if (v == -1.0f || w2 == -1.0f) {
                    return;
                }
                this.f[pointerId] = v;
                this.g[pointerId] = w2;
            }
        }
    }

    public final void i(int i) {
        float[] fArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048597, this, i) != null) || (fArr = this.d) == null) {
            return;
        }
        fArr[i] = 0.0f;
        this.e[i] = 0.0f;
        this.f[i] = 0.0f;
        this.g[i] = 0.0f;
        this.h[i] = 0;
        this.i[i] = 0;
        this.j[i] = 0;
        this.k = (~(1 << i)) & this.k;
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && this.a != i) {
            this.a = i;
            this.r.k(i);
            if (this.a == 0) {
                this.s = null;
            }
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.p = i;
        }
    }

    public void I(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            this.n = f;
        }
    }

    public final float p(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048602, this, f)) == null) {
            return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
        }
        return invokeF.floatValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public boolean J(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) {
            if (this.t) {
                return t(i, i2, (int) VelocityTrackerCompat.getXVelocity(this.l, this.c), (int) VelocityTrackerCompat.getYVelocity(this.l, this.c));
            }
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return invokeII.booleanValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void c(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, view2, i) == null) {
            if (view2.getParent() == this.u) {
                this.s = view2;
                this.c = i;
                this.r.j(view2, i);
                G(1);
                return;
            }
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public final void o(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.t = true;
            this.r.m(this.s, f, f2);
            this.t = false;
            if (this.a == 1) {
                G(0);
            }
        }
    }

    public View s(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048605, this, i, i2)) == null) {
            for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
                ViewGroup viewGroup = this.u;
                this.r.c(childCount);
                View childAt = viewGroup.getChildAt(childCount);
                if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeII.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ee, code lost:
        if (r13 != r12) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean K(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        View s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (actionMasked == 0) {
                b();
            }
            if (this.l == null) {
                this.l = VelocityTracker.obtain();
            }
            this.l.addMovement(motionEvent);
            boolean z2 = false;
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    float f = -1.0f;
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked != 5) {
                                if (actionMasked == 6) {
                                    i(MotionEventCompat.getPointerId(motionEvent, actionIndex));
                                }
                            } else {
                                int pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                                float v = v(motionEvent, actionIndex);
                                float w2 = w(motionEvent, actionIndex);
                                if (v == -1.0f || w2 == -1.0f) {
                                    return false;
                                }
                                E(v, w2, pointerId);
                                int i = this.a;
                                if (i == 0) {
                                    int i2 = this.h[pointerId];
                                    int i3 = this.p;
                                    if ((i2 & i3) != 0) {
                                        this.r.i(i2 & i3, pointerId);
                                    }
                                } else if (i == 2 && (s = s((int) v, (int) w2)) == this.s) {
                                    M(s, pointerId);
                                }
                            }
                        } else {
                            b();
                        }
                    } else {
                        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                        int i4 = 0;
                        while (i4 < pointerCount) {
                            int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i4);
                            float v2 = v(motionEvent, i4);
                            float w3 = w(motionEvent, i4);
                            if (v2 == f) {
                                return z2;
                            }
                            if (w3 == f) {
                                return z2;
                            }
                            float f2 = v2 - this.d[pointerId2];
                            float f3 = w3 - this.e[pointerId2];
                            View s2 = s((int) v2, (int) w3);
                            if (s2 != null && e(s2, f2, f3)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                int left = s2.getLeft();
                                int i5 = (int) f2;
                                int a2 = this.r.a(s2, left + i5, i5);
                                int top = s2.getTop();
                                int i6 = (int) f3;
                                int b2 = this.r.b(s2, top + i6, i6);
                                int d = this.r.d(s2);
                                int e = this.r.e(s2);
                                if (d != 0) {
                                    if (d > 0) {
                                    }
                                }
                                if (e != 0) {
                                    if (e > 0 && b2 == top) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            D(f2, f3, pointerId2);
                            if (this.a == 1 || (z && M(s2, pointerId2))) {
                                break;
                            }
                            i4++;
                            z2 = false;
                            f = -1.0f;
                        }
                        F(motionEvent);
                    }
                } else {
                    b();
                }
            } else {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId3 = MotionEventCompat.getPointerId(motionEvent, 0);
                E(x, y, pointerId3);
                View s3 = s((int) x, (int) y);
                if (s3 == this.s && this.a == 2) {
                    M(s3, pointerId3);
                }
                int i7 = this.h[pointerId3];
                int i8 = this.p;
                if ((i7 & i8) != 0) {
                    this.r.i(i7 & i8, pointerId3);
                }
            }
            if (this.a == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean d(float f, float f2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            float abs = Math.abs(f);
            float abs2 = Math.abs(f2);
            if ((this.h[i] & i2) != i2 || (this.p & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
                return false;
            }
            int i3 = this.b;
            if (abs <= i3 && abs2 <= i3) {
                return false;
            }
            if (abs < abs2 * 0.5f && this.r.h(i2)) {
                int[] iArr = this.j;
                iArr[i] = iArr[i] | i2;
                return false;
            } else if ((this.i[i] & i2) != 0 || abs <= this.b) {
                return false;
            } else {
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final int k(View view2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int g = g(i3, (int) this.n, (int) this.m);
            int g2 = g(i4, (int) this.n, (int) this.m);
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            int abs3 = Math.abs(g);
            int abs4 = Math.abs(g2);
            int i5 = abs3 + abs4;
            int i6 = abs + abs2;
            if (g != 0) {
                f = abs3;
                f2 = i5;
            } else {
                f = abs;
                f2 = i6;
            }
            float f5 = f / f2;
            if (g2 != 0) {
                f3 = abs4;
                f4 = i5;
            } else {
                f3 = abs2;
                f4 = i6;
            }
            return (int) ((j(i, g, this.r.d(view2)) * f5) + (j(i2, g2, this.r.e(view2)) * (f3 / f4)));
        }
        return invokeCommon.intValue;
    }

    public boolean l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            if (this.a == 2) {
                boolean computeScrollOffset = this.q.computeScrollOffset();
                int currX = this.q.getCurrX();
                int currY = this.q.getCurrY();
                int left = currX - this.s.getLeft();
                int top = currY - this.s.getTop();
                if (left != 0) {
                    this.s.offsetLeftAndRight(left);
                }
                if (top != 0) {
                    this.s.offsetTopAndBottom(top);
                }
                if (left != 0 || top != 0) {
                    this.r.l(this.s, currX, currY, left, top);
                }
                if (computeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                    this.q.abortAnimation();
                    computeScrollOffset = false;
                }
                if (!computeScrollOffset) {
                    if (z) {
                        this.u.post(this.v);
                    } else {
                        G(0);
                    }
                }
            }
            if (this.a != 2) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void q(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048603, this, i, i2, i3, i4) == null) {
            int left = this.s.getLeft();
            int top = this.s.getTop();
            if (i3 != 0) {
                i = this.r.a(this.s, i, i3);
                if (this.r.f()) {
                    this.s.offsetLeftAndRight(i - left);
                }
            }
            int i5 = i;
            if (i4 != 0) {
                i2 = this.r.b(this.s, i2, i4);
                this.s.offsetTopAndBottom(i2 - top);
            }
            int i6 = i2;
            if (i3 != 0 || i4 != 0) {
                int i7 = i5 - left;
                int i8 = i6 - top;
                if (this.r.f()) {
                    this.r.l(this.s, i5, i6, i7, i8);
                }
            }
        }
    }

    public final void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            float[] fArr = this.d;
            if (fArr == null || fArr.length <= i) {
                int i2 = i + 1;
                float[] fArr2 = new float[i2];
                float[] fArr3 = new float[i2];
                float[] fArr4 = new float[i2];
                float[] fArr5 = new float[i2];
                int[] iArr = new int[i2];
                int[] iArr2 = new int[i2];
                int[] iArr3 = new int[i2];
                float[] fArr6 = this.d;
                if (fArr6 != null) {
                    System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                    float[] fArr7 = this.e;
                    System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                    float[] fArr8 = this.f;
                    System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                    float[] fArr9 = this.g;
                    System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                    int[] iArr4 = this.h;
                    System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                    int[] iArr5 = this.i;
                    System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                    int[] iArr6 = this.j;
                    System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
                }
                this.d = fArr2;
                this.e = fArr3;
                this.f = fArr4;
                this.g = fArr5;
                this.h = iArr;
                this.i = iArr2;
                this.j = iArr3;
            }
        }
    }

    public final boolean t(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048606, this, i, i2, i3, i4)) == null) {
            int left = this.s.getLeft();
            int top = this.s.getTop();
            int i5 = i - left;
            int i6 = i2 - top;
            if (i5 == 0 && i6 == 0) {
                this.q.abortAnimation();
                G(0);
                return false;
            }
            this.q.startScroll(left, top, i5, i6, k(this.s, i5, i6, i3, i4));
            G(2);
            return true;
        }
        return invokeIIII.booleanValue;
    }

    public final int u(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048607, this, i, i2)) == null) {
            if (i < this.u.getLeft() + this.o) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i2 < this.u.getTop() + this.o) {
                i3 |= 4;
            }
            if (i > this.u.getRight() - this.o) {
                i3 |= 2;
            }
            if (i2 > this.u.getBottom() - this.o) {
                return i3 | 8;
            }
            return i3;
        }
        return invokeII.intValue;
    }
}
