package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.bw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class n03 implements ty2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public bw2 a;
    public String b;
    public p03 c;
    public boolean d;
    public Context e;
    public boolean f;
    public o03 g;

    @Override // com.baidu.tieba.ty2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements bw2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n03 a;

        public a(n03 n03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n03Var;
        }

        @Override // com.baidu.tieba.bw2.a
        public void b(bw2 bw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw2Var) == null) && this.a.g != null) {
                this.a.g.b(bw2Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bw2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n03 a;

        public b(n03 n03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n03Var;
        }

        @Override // com.baidu.tieba.bw2.b
        public boolean f(bw2 bw2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bw2Var, i, i2)) == null) {
                if (this.a.g != null && this.a.g.f(bw2Var, i, i2)) {
                    return true;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements bw2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n03 a;

        public c(n03 n03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n03Var;
        }

        @Override // com.baidu.tieba.bw2.d
        public void e(bw2 bw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw2Var) == null) && this.a.g != null) {
                this.a.g.e(bw2Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements bw2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n03 a;

        public d(n03 n03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n03Var;
        }

        @Override // com.baidu.tieba.bw2.e
        public void a(bw2 bw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw2Var) == null) && this.a.g != null) {
                this.a.g.a(bw2Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements bw2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n03 a;

        public e(n03 n03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n03Var;
        }

        @Override // com.baidu.tieba.bw2.f
        public void d(bw2 bw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw2Var) == null) && this.a.g != null) {
                this.a.g.d(bw2Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements bw2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n03 a;

        public f(n03 n03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n03Var;
        }

        @Override // com.baidu.tieba.bw2.c
        public void c(bw2 bw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw2Var) == null) && this.a.g != null) {
                this.a.g.c(bw2Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947948600, "Lcom/baidu/tieba/n03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947948600, "Lcom/baidu/tieba/n03;");
                return;
            }
        }
        h = fs1.a;
    }

    @Override // com.baidu.tieba.ty2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty2
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
            uy2.a(this);
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

    @Override // com.baidu.tieba.ty2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            p03 p03Var = this.c;
            if (p03Var != null) {
                return p03Var.z;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public p03 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (p03) invokeV.objValue;
    }

    public void l() {
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (bw2Var = this.a) != null) {
            bw2Var.f();
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            bw2 bw2Var = this.a;
            if (bw2Var != null && bw2Var.isEnd()) {
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
            bw2 bw2Var = this.a;
            if (bw2Var != null && bw2Var.isPlaying()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ty2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            v82.i("video", "onBackPressed");
            bw2 bw2Var = this.a;
            if (bw2Var != null && bw2Var.onBackPressed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ty2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            v82.i("video", MissionEvent.MESSAGE_DESTROY);
            bw2 bw2Var = this.a;
            if (bw2Var != null) {
                bw2Var.stop();
                this.a = null;
            }
            uy2.k(this);
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
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && B() && !n() && this.f && (bw2Var = this.a) != null) {
            bw2Var.resume();
        }
    }

    public void y() {
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && B() && (bw2Var = this.a) != null) {
            bw2Var.seekTo(0);
            this.a.pause();
        }
    }

    public n03(Context context, @NonNull p03 p03Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, p03Var};
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
        this.c = p03Var;
        this.b = p03Var.j;
        h();
        d();
    }

    public void A(p03 p03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, p03Var) == null) {
            if (h) {
                Log.e("SwanAppVideoPlayer", "update 接口");
            }
            bw2 bw2Var = this.a;
            if (bw2Var != null) {
                bw2Var.h(p03Var, true);
            }
            this.c = p03Var;
        }
    }

    public void o(p03 p03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, p03Var) == null) {
            v82.i("video", "Open Player " + p03Var.j);
            bw2 bw2Var = this.a;
            if (bw2Var != null) {
                bw2Var.o(p03Var);
            }
            this.c = p03Var;
        }
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            bw2 bw2Var = this.a;
            if (bw2Var != null) {
                return bw2Var.q(str);
            }
            return 1001;
        }
        return invokeL.intValue;
    }

    public void r(String str) {
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (bw2Var = this.a) != null) {
            bw2Var.i(str);
        }
    }

    public void t(int i) {
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && B() && (bw2Var = this.a) != null) {
            bw2Var.seekTo(i);
        }
    }

    public void v(o03 o03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, o03Var) == null) {
            this.g = o03Var;
        }
    }

    public void w(boolean z) {
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048601, this, z) == null) && (bw2Var = this.a) != null) {
            bw2Var.d(z);
        }
    }

    public void x(FrameLayout frameLayout) {
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, frameLayout) == null) && (bw2Var = this.a) != null) {
            bw2Var.a(frameLayout);
        }
    }

    public void z(p03 p03Var) {
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, p03Var) == null) && (bw2Var = this.a) != null) {
            bw2Var.n(p03Var);
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            p03 p03Var = this.c;
            if (p03Var != null && !TextUtils.isEmpty(p03Var.y) && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c.b)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public bw2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == null) {
                v82.i("video", "create player");
                bw2 C0 = cv2.C0();
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
        return (bw2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty2
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
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (bw2Var = this.a) != null) {
            bw2Var.l(z, i);
        }
    }
}
