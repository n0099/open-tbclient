package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.gl2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sp2 implements yn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public gl2 a;
    public String b;
    public up2 c;
    public boolean d;
    public Context e;
    public boolean f;
    public tp2 g;

    /* loaded from: classes5.dex */
    public class a implements gl2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp2 a;

        public a(sp2 sp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp2Var;
        }

        @Override // com.baidu.tieba.gl2.a
        public void b(gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, gl2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.b(gl2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements gl2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp2 a;

        public b(sp2 sp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp2Var;
        }

        @Override // com.baidu.tieba.gl2.b
        public boolean f(gl2 gl2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, gl2Var, i, i2)) == null) ? this.a.g != null && this.a.g.f(gl2Var, i, i2) : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements gl2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp2 a;

        public c(sp2 sp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp2Var;
        }

        @Override // com.baidu.tieba.gl2.d
        public void e(gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, gl2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.e(gl2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements gl2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp2 a;

        public d(sp2 sp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp2Var;
        }

        @Override // com.baidu.tieba.gl2.e
        public void a(gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, gl2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.a(gl2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements gl2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp2 a;

        public e(sp2 sp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp2Var;
        }

        @Override // com.baidu.tieba.gl2.f
        public void d(gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, gl2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.d(gl2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements gl2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp2 a;

        public f(sp2 sp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sp2Var;
        }

        @Override // com.baidu.tieba.gl2.c
        public void c(gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, gl2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.c(gl2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948159028, "Lcom/baidu/tieba/sp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948159028, "Lcom/baidu/tieba/sp2;");
                return;
            }
        }
        h = kh1.a;
    }

    public sp2(Context context, @NonNull up2 up2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, up2Var};
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
        this.c = up2Var;
        this.b = up2Var.j;
        h();
        d();
    }

    public void A(up2 up2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, up2Var) == null) {
            if (h) {
                Log.e("SwanAppVideoPlayer", "update 接口");
            }
            gl2 gl2Var = this.a;
            if (gl2Var != null) {
                gl2Var.h(up2Var, true);
            }
            this.c = up2Var;
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            up2 up2Var = this.c;
            return (up2Var == null || TextUtils.isEmpty(up2Var.y) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c.b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yn2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c.c : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || TextUtils.isEmpty(this.b)) {
            return;
        }
        zn2.a(this);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.yn2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            up2 up2Var = this.c;
            return up2Var != null ? up2Var.z : "";
        }
        return (String) invokeV.objValue;
    }

    public up2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (up2) invokeV.objValue;
    }

    public gl2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == null) {
                ay1.i("video", "create player");
                gl2 C0 = hk2.C0();
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
        return (gl2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.yn2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.yn2
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

    public void l() {
        gl2 gl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (gl2Var = this.a) == null) {
            return;
        }
        gl2Var.f();
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            gl2 gl2Var = this.a;
            return gl2Var != null && gl2Var.isEnd();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            gl2 gl2Var = this.a;
            return gl2Var != null && gl2Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void o(up2 up2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, up2Var) == null) {
            ay1.i("video", "Open Player " + up2Var.j);
            gl2 gl2Var = this.a;
            if (gl2Var != null) {
                gl2Var.o(up2Var);
            }
            this.c = up2Var;
        }
    }

    @Override // com.baidu.tieba.yn2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ay1.i("video", "onBackPressed");
            gl2 gl2Var = this.a;
            return gl2Var != null && gl2Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yn2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ay1.i("video", MissionEvent.MESSAGE_DESTROY);
            gl2 gl2Var = this.a;
            if (gl2Var != null) {
                gl2Var.stop();
                this.a = null;
            }
            zn2.k(this);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && B()) {
            h().pause();
        }
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            gl2 gl2Var = this.a;
            if (gl2Var != null) {
                return gl2Var.q(str);
            }
            return 1001;
        }
        return invokeL.intValue;
    }

    public void r(String str) {
        gl2 gl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (gl2Var = this.a) == null) {
            return;
        }
        gl2Var.i(str);
    }

    public void s() {
        gl2 gl2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && B() && !n() && this.f && (gl2Var = this.a) != null) {
            gl2Var.resume();
        }
    }

    public void t(int i) {
        gl2 gl2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && B() && (gl2Var = this.a) != null) {
            gl2Var.seekTo(i);
        }
    }

    public void u(boolean z, int i) {
        gl2 gl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (gl2Var = this.a) == null) {
            return;
        }
        gl2Var.l(z, i);
    }

    public void v(tp2 tp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, tp2Var) == null) {
            this.g = tp2Var;
        }
    }

    public void w(boolean z) {
        gl2 gl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (gl2Var = this.a) == null) {
            return;
        }
        gl2Var.d(z);
    }

    public void x(FrameLayout frameLayout) {
        gl2 gl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, frameLayout) == null) || (gl2Var = this.a) == null) {
            return;
        }
        gl2Var.a(frameLayout);
    }

    public void y() {
        gl2 gl2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && B() && (gl2Var = this.a) != null) {
            gl2Var.seekTo(0);
            this.a.pause();
        }
    }

    public void z(up2 up2Var) {
        gl2 gl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, up2Var) == null) || (gl2Var = this.a) == null) {
            return;
        }
        gl2Var.n(up2Var);
    }
}
