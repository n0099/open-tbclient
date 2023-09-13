package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.nv2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes8.dex */
public class uu2 implements c04, fy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nv2 a;
    public wz3 b;
    public Context c;
    public b03 d;
    public String e;
    public boolean f;
    public boolean g;

    @Override // com.baidu.tieba.fy2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.fy2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements nv2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uu2 a;

        public a(uu2 uu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uu2Var;
        }

        @Override // com.baidu.tieba.nv2.a
        public void b(nv2 nv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, nv2Var) == null) && this.a.b != null) {
                this.a.b.onCompletion();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements nv2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uu2 a;

        public b(uu2 uu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uu2Var;
        }

        @Override // com.baidu.tieba.nv2.b
        public boolean f(nv2 nv2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, nv2Var, i, i2)) == null) {
                if (this.a.b != null && this.a.b.onError()) {
                    return true;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements nv2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uu2 a;

        public c(uu2 uu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uu2Var;
        }

        @Override // com.baidu.tieba.nv2.d
        public void e(nv2 nv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, nv2Var) == null) && this.a.b != null) {
                this.a.b.onPrepared();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements nv2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uu2 a;

        public d(uu2 uu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uu2Var;
        }

        @Override // com.baidu.tieba.nv2.e
        public void a(nv2 nv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, nv2Var) == null) && this.a.b != null) {
                this.a.b.onResume();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements nv2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uu2 a;

        public e(uu2 uu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uu2Var;
        }

        @Override // com.baidu.tieba.nv2.f
        public void d(nv2 nv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, nv2Var) == null) && this.a.b != null) {
                this.a.b.onStart();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements nv2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uu2 a;

        public f(uu2 uu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uu2Var;
        }

        @Override // com.baidu.tieba.nv2.c
        public void c(nv2 nv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, nv2Var) == null) && this.a.b != null) {
                this.a.b.onPause();
            }
        }
    }

    public uu2() {
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
        this.f = true;
    }

    @Override // com.baidu.tieba.fy2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fy2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fy2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b03 b03Var = this.d;
            if (b03Var != null) {
                return b03Var.z;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c04
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return o().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.c04
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return o().getDuration();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.c04
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            nv2 nv2Var = this.a;
            if (nv2Var != null && nv2Var.isEnd()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c04
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            nv2 nv2Var = this.a;
            if (nv2Var != null && nv2Var.isPlaying()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !TextUtils.isEmpty(this.e)) {
            gy2.a(this);
        }
    }

    @Override // com.baidu.tieba.fy2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            nv2 nv2Var = this.a;
            if (nv2Var != null) {
                nv2Var.stop();
                this.a = null;
            }
            gy2.k(this);
        }
    }

    @Override // com.baidu.tieba.c04
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || !q()) {
            return;
        }
        o().pause();
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b03 b03Var = this.d;
            if (b03Var != null && !TextUtils.isEmpty(b03Var.y)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c04
    public void resume() {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f && (nv2Var = this.a) != null) {
            nv2Var.resume();
        }
    }

    @Override // com.baidu.tieba.c04
    public void stop() {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (nv2Var = this.a) != null) {
            nv2Var.stop();
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.c04
    public void a(FrameLayout frameLayout) {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) && (nv2Var = this.a) != null) {
            nv2Var.a(frameLayout);
        }
    }

    @Override // com.baidu.tieba.c04
    public void d(boolean z) {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (nv2Var = this.a) != null) {
            nv2Var.d(z);
        }
    }

    @Override // com.baidu.tieba.c04
    public void g(wz3 wz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, wz3Var) == null) {
            this.b = wz3Var;
        }
    }

    @Override // com.baidu.tieba.c04
    public void h(yy3 yy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yy3Var) == null) {
            b03 p = p(yy3Var);
            this.d = p;
            nv2 nv2Var = this.a;
            if (nv2Var != null) {
                nv2Var.o(p);
            }
        }
    }

    @Override // com.baidu.tieba.c04
    public void mute(boolean z) {
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (nv2Var = this.a) != null) {
            nv2Var.mute(z);
        }
    }

    @Override // com.baidu.tieba.c04
    public /* bridge */ /* synthetic */ c04 e(Context context, @NonNull yy3 yy3Var) {
        n(context, yy3Var);
        return this;
    }

    public uu2 n(Context context, @NonNull yy3 yy3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, yy3Var)) == null) {
            this.c = context;
            b03 p = p(yy3Var);
            this.d = p;
            this.e = p.j;
            o();
            m();
            return this;
        }
        return (uu2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.fy2
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f = z;
            if (this.a == null) {
                return;
            }
            if (z) {
                if (this.g) {
                    o().resume();
                }
                o().b();
                return;
            }
            this.g = o().isPlaying();
            o().pause();
            o().c();
        }
    }

    public b03 p(yy3 yy3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, yy3Var)) == null) {
            b03 b03Var = new b03();
            b03Var.j = "SwanAdPlayer";
            b03Var.b = "SwanAdPlayer";
            b03Var.o = yy3Var.f;
            b03Var.k = yy3Var.b;
            b03Var.x = yy3Var.o;
            b03Var.I = yy3Var.z;
            b03Var.E = yy3Var.v;
            b03Var.y = yy3Var.p;
            return b03Var;
        }
        return (b03) invokeL.objValue;
    }

    public nv2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                nv2 C0 = ou2.C0();
                C0.e(this.c, this.d);
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
}
