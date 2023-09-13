package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.nv2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zz2 implements fy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public nv2 a;
    public String b;
    public b03 c;
    public boolean d;
    public Context e;
    public boolean f;
    public a03 g;

    @Override // com.baidu.tieba.fy2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.fy2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements nv2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz2 a;

        public a(zz2 zz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz2Var;
        }

        @Override // com.baidu.tieba.nv2.a
        public void b(nv2 nv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, nv2Var) == null) && this.a.g != null) {
                this.a.g.b(nv2Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements nv2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz2 a;

        public b(zz2 zz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz2Var;
        }

        @Override // com.baidu.tieba.nv2.b
        public boolean f(nv2 nv2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, nv2Var, i, i2)) == null) {
                if (this.a.g != null && this.a.g.f(nv2Var, i, i2)) {
                    return true;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements nv2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz2 a;

        public c(zz2 zz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz2Var;
        }

        @Override // com.baidu.tieba.nv2.d
        public void e(nv2 nv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, nv2Var) == null) && this.a.g != null) {
                this.a.g.e(nv2Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements nv2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz2 a;

        public d(zz2 zz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz2Var;
        }

        @Override // com.baidu.tieba.nv2.e
        public void a(nv2 nv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, nv2Var) == null) && this.a.g != null) {
                this.a.g.a(nv2Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements nv2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz2 a;

        public e(zz2 zz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz2Var;
        }

        @Override // com.baidu.tieba.nv2.f
        public void d(nv2 nv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, nv2Var) == null) && this.a.g != null) {
                this.a.g.d(nv2Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements nv2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz2 a;

        public f(zz2 zz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz2Var;
        }

        @Override // com.baidu.tieba.nv2.c
        public void c(nv2 nv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, nv2Var) == null) && this.a.g != null) {
                this.a.g.c(nv2Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948377175, "Lcom/baidu/tieba/zz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948377175, "Lcom/baidu/tieba/zz2;");
                return;
            }
        }
        h = rr1.a;
    }

    @Override // com.baidu.tieba.fy2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fy2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !TextUtils.isEmpty(this.b)) {
            gy2.a(this);
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return h().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fy2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b03 b03Var = this.c;
            if (b03Var != null) {
                return b03Var.z;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public b03 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (b03) invokeV.objValue;
    }

    public void l() {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (nv2Var = this.a) != null) {
            nv2Var.f();
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            nv2 nv2Var = this.a;
            if (nv2Var != null && nv2Var.isEnd()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            nv2 nv2Var = this.a;
            if (nv2Var != null && nv2Var.isPlaying()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fy2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            h82.i("video", "onBackPressed");
            nv2 nv2Var = this.a;
            if (nv2Var != null && nv2Var.onBackPressed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fy2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            h82.i("video", MissionEvent.MESSAGE_DESTROY);
            nv2 nv2Var = this.a;
            if (nv2Var != null) {
                nv2Var.stop();
                this.a = null;
            }
            gy2.k(this);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || !B()) {
            return;
        }
        h().pause();
    }

    public void s() {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && B() && !n() && this.f && (nv2Var = this.a) != null) {
            nv2Var.resume();
        }
    }

    public void y() {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && B() && (nv2Var = this.a) != null) {
            nv2Var.seekTo(0);
            this.a.pause();
        }
    }

    public zz2(Context context, @NonNull b03 b03Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, b03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = true;
        this.e = context;
        this.c = b03Var;
        this.b = b03Var.j;
        h();
        d();
    }

    public void A(b03 b03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b03Var) == null) {
            if (h) {
                Log.e("SwanAppVideoPlayer", "update 接口");
            }
            nv2 nv2Var = this.a;
            if (nv2Var != null) {
                nv2Var.h(b03Var, true);
            }
            this.c = b03Var;
        }
    }

    public void o(b03 b03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, b03Var) == null) {
            h82.i("video", "Open Player " + b03Var.j);
            nv2 nv2Var = this.a;
            if (nv2Var != null) {
                nv2Var.o(b03Var);
            }
            this.c = b03Var;
        }
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            nv2 nv2Var = this.a;
            if (nv2Var != null) {
                return nv2Var.q(str);
            }
            return 1001;
        }
        return invokeL.intValue;
    }

    public void r(String str) {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (nv2Var = this.a) != null) {
            nv2Var.i(str);
        }
    }

    public void t(int i) {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && B() && (nv2Var = this.a) != null) {
            nv2Var.seekTo(i);
        }
    }

    public void v(a03 a03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, a03Var) == null) {
            this.g = a03Var;
        }
    }

    public void w(boolean z) {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048601, this, z) == null) && (nv2Var = this.a) != null) {
            nv2Var.d(z);
        }
    }

    public void x(FrameLayout frameLayout) {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, frameLayout) == null) && (nv2Var = this.a) != null) {
            nv2Var.a(frameLayout);
        }
    }

    public void z(b03 b03Var) {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, b03Var) == null) && (nv2Var = this.a) != null) {
            nv2Var.n(b03Var);
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b03 b03Var = this.c;
            if (b03Var != null && !TextUtils.isEmpty(b03Var.y) && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c.b)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public nv2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == null) {
                h82.i("video", "create player");
                nv2 C0 = ou2.C0();
                C0.e(this.e, this.c);
                this.a = C0;
                C0.g(new a(this));
                this.a.p(new b(this));
                this.a.m(new c(this));
                this.a.j(new d(this));
                this.a.k(new e(this));
                this.a.r(new f(this));
            }
            return this.a;
        }
        return (nv2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fy2
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f = z;
            if (z) {
                if (this.d) {
                    h().resume();
                }
                h().b();
            } else if (this.a != null) {
                this.d = h().isPlaying();
                h().pause();
                h().c();
            }
        }
    }

    public void u(boolean z, int i) {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (nv2Var = this.a) != null) {
            nv2Var.l(z, i);
        }
    }
}
