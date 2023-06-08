package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.lw6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ve7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public NavigationBar b;
    public od7 c;
    public Context d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public mw6 j;
    public final Handler.Callback k;
    public final Handler l;
    public lw6.b m;

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve7 a;

        public a(ve7 ve7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve7Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if ((i == 1 || i == 2) && this.a.g()) {
                    this.a.l.sendEmptyMessageDelayed(message.what, 100L);
                    return true;
                }
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return false;
                        }
                        this.a.q();
                        return true;
                    }
                    this.a.r();
                    return true;
                }
                this.a.s();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements lw6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve7 a;

        @Override // com.baidu.tieba.lw6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.lw6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public b(ve7 ve7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve7Var;
        }

        public final boolean e(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) {
                if (Math.abs(f) >= 1.0f) {
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }

        @Override // com.baidu.tieba.lw6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (e(i2)) {
                    this.a.k(true);
                    this.a.f();
                }
                if (this.a.c != null) {
                    this.a.c.y1(false);
                }
            }
        }

        @Override // com.baidu.tieba.lw6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                if (e(i2)) {
                    this.a.k(false);
                    this.a.m();
                }
                if (this.a.c != null) {
                    this.a.c.y1(true);
                }
            }
        }
    }

    public ve7(Context context, od7 od7Var, pr7 pr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, od7Var, pr7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.f = 0;
        this.h = true;
        this.i = true;
        this.k = new a(this);
        this.l = new Handler(this.k);
        this.m = new b(this);
        this.d = context;
        this.c = od7Var;
        this.b = od7Var.k0();
        this.a = od7Var.m0();
        this.g = UtilHelper.canUseStyleImmersiveSticky();
        c();
        mw6 mw6Var = new mw6(context);
        this.j = mw6Var;
        mw6Var.d(this.m);
    }

    public final boolean h(View view2) {
        InterceptResult invokeL;
        Animation animation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            if (view2 == null || (animation = view2.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.h = z;
        }
    }

    public final void c() {
        od7 od7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (od7Var = this.c) != null && od7Var.s0() != null) {
            View s0 = this.c.s0();
            if (this.g && s0.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = s0.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                s0.setLayoutParams(layoutParams);
                l(true);
                return;
            }
            l(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l.removeCallbacksAndMessages(null);
        }
    }

    public mw6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (mw6) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !this.h || !this.i || this.a == null || this.e < this.f) {
            return;
        }
        n();
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return h(this.a);
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || !this.h || !this.i || this.a == null) {
            return;
        }
        o();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.removeMessages(1);
            if (!this.l.hasMessages(2)) {
                this.l.sendEmptyMessageDelayed(2, 110L);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.l.removeMessages(2);
            if (!this.l.hasMessages(1)) {
                this.l.sendEmptyMessageDelayed(1, 60L);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            p(false, true);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            p(false, false);
        }
    }

    public void s() {
        od7 od7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.a != null && (od7Var = this.c) != null && od7Var.q0() != null && !this.c.q0().c()) {
            j(true, true);
        }
    }

    public final void j(boolean z, boolean z2) {
        od7 od7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || (od7Var = this.c) == null) {
            return;
        }
        od7Var.u1(z, z2);
    }

    public final void l(boolean z) {
        od7 od7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (od7Var = this.c) != null && od7Var.s0() != null) {
            View s0 = this.c.s0();
            if (this.g && z && s0.getVisibility() != 0) {
                s0.setVisibility(0);
            } else if (!z && s0.getVisibility() != 8) {
                s0.setVisibility(8);
            }
        }
    }

    public void p(boolean z, boolean z2) {
        od7 od7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.a != null && (od7Var = this.c) != null && od7Var.q0() != null && this.c.q0().c()) {
            j(false, true);
        }
    }
}
