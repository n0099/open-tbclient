package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.qq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes9.dex */
public class xp2 implements fv3, it2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qq2 a;
    public zu3 b;
    public Context c;
    public ev2 d;
    public String e;
    public boolean f;
    public boolean g;

    @Override // com.baidu.tieba.it2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements qq2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp2 a;

        public a(xp2 xp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp2Var;
        }

        @Override // com.baidu.tieba.qq2.a
        public void b(qq2 qq2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, qq2Var) == null) && this.a.b != null) {
                this.a.b.onCompletion();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements qq2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp2 a;

        public b(xp2 xp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp2Var;
        }

        @Override // com.baidu.tieba.qq2.b
        public boolean f(qq2 qq2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, qq2Var, i, i2)) == null) {
                if (this.a.b != null && this.a.b.onError()) {
                    return true;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements qq2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp2 a;

        public c(xp2 xp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp2Var;
        }

        @Override // com.baidu.tieba.qq2.d
        public void e(qq2 qq2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, qq2Var) == null) && this.a.b != null) {
                this.a.b.onPrepared();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements qq2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp2 a;

        public d(xp2 xp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp2Var;
        }

        @Override // com.baidu.tieba.qq2.e
        public void a(qq2 qq2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, qq2Var) == null) && this.a.b != null) {
                this.a.b.onResume();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements qq2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp2 a;

        public e(xp2 xp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp2Var;
        }

        @Override // com.baidu.tieba.qq2.f
        public void d(qq2 qq2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, qq2Var) == null) && this.a.b != null) {
                this.a.b.onStart();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements qq2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp2 a;

        public f(xp2 xp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp2Var;
        }

        @Override // com.baidu.tieba.qq2.c
        public void c(qq2 qq2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, qq2Var) == null) && this.a.b != null) {
                this.a.b.onPause();
            }
        }
    }

    public xp2() {
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

    @Override // com.baidu.tieba.it2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ev2 ev2Var = this.d;
            if (ev2Var != null) {
                return ev2Var.z;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fv3
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return o().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fv3
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return o().getDuration();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fv3
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            qq2 qq2Var = this.a;
            if (qq2Var != null && qq2Var.isEnd()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fv3
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            qq2 qq2Var = this.a;
            if (qq2Var != null && qq2Var.isPlaying()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !TextUtils.isEmpty(this.e)) {
            jt2.a(this);
        }
    }

    @Override // com.baidu.tieba.it2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            qq2 qq2Var = this.a;
            if (qq2Var != null && qq2Var.onBackPressed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.it2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            qq2 qq2Var = this.a;
            if (qq2Var != null) {
                qq2Var.stop();
                this.a = null;
            }
            jt2.k(this);
        }
    }

    @Override // com.baidu.tieba.fv3
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
            ev2 ev2Var = this.d;
            if (ev2Var != null && !TextUtils.isEmpty(ev2Var.y)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fv3
    public void resume() {
        qq2 qq2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f && (qq2Var = this.a) != null) {
            qq2Var.resume();
        }
    }

    @Override // com.baidu.tieba.fv3
    public void stop() {
        qq2 qq2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (qq2Var = this.a) != null) {
            qq2Var.stop();
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.fv3
    public void a(FrameLayout frameLayout) {
        qq2 qq2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) && (qq2Var = this.a) != null) {
            qq2Var.a(frameLayout);
        }
    }

    @Override // com.baidu.tieba.fv3
    public void d(boolean z) {
        qq2 qq2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (qq2Var = this.a) != null) {
            qq2Var.d(z);
        }
    }

    @Override // com.baidu.tieba.fv3
    public void g(zu3 zu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, zu3Var) == null) {
            this.b = zu3Var;
        }
    }

    @Override // com.baidu.tieba.fv3
    public void h(bu3 bu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bu3Var) == null) {
            ev2 p = p(bu3Var);
            this.d = p;
            qq2 qq2Var = this.a;
            if (qq2Var != null) {
                qq2Var.o(p);
            }
        }
    }

    @Override // com.baidu.tieba.fv3
    public void mute(boolean z) {
        qq2 qq2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (qq2Var = this.a) != null) {
            qq2Var.mute(z);
        }
    }

    @Override // com.baidu.tieba.fv3
    public /* bridge */ /* synthetic */ fv3 e(Context context, @NonNull bu3 bu3Var) {
        n(context, bu3Var);
        return this;
    }

    public xp2 n(Context context, @NonNull bu3 bu3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, bu3Var)) == null) {
            this.c = context;
            ev2 p = p(bu3Var);
            this.d = p;
            this.e = p.j;
            o();
            m();
            return this;
        }
        return (xp2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.it2
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

    public ev2 p(bu3 bu3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bu3Var)) == null) {
            ev2 ev2Var = new ev2();
            ev2Var.j = "SwanAdPlayer";
            ev2Var.b = "SwanAdPlayer";
            ev2Var.o = bu3Var.f;
            ev2Var.k = bu3Var.b;
            ev2Var.x = bu3Var.o;
            ev2Var.I = bu3Var.z;
            ev2Var.E = bu3Var.v;
            ev2Var.y = bu3Var.p;
            return ev2Var;
        }
        return (ev2) invokeL.objValue;
    }

    public qq2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                qq2 C0 = rp2.C0();
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
        return (qq2) invokeV.objValue;
    }
}
