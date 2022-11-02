package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.ko2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes5.dex */
public class rn2 implements zs3, cr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ko2 a;
    public ts3 b;
    public Context c;
    public ys2 d;
    public String e;
    public boolean f;
    public boolean g;

    @Override // com.baidu.tieba.cr2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ko2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn2 a;

        public a(rn2 rn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn2Var;
        }

        @Override // com.baidu.tieba.ko2.a
        public void b(ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ko2Var) == null) && this.a.b != null) {
                this.a.b.onCompletion();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ko2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn2 a;

        public b(rn2 rn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn2Var;
        }

        @Override // com.baidu.tieba.ko2.b
        public boolean f(ko2 ko2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, ko2Var, i, i2)) == null) {
                if (this.a.b != null && this.a.b.onError()) {
                    return true;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ko2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn2 a;

        public c(rn2 rn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn2Var;
        }

        @Override // com.baidu.tieba.ko2.d
        public void e(ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ko2Var) == null) && this.a.b != null) {
                this.a.b.onPrepared();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ko2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn2 a;

        public d(rn2 rn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn2Var;
        }

        @Override // com.baidu.tieba.ko2.e
        public void a(ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ko2Var) == null) && this.a.b != null) {
                this.a.b.onResume();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ko2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn2 a;

        public e(rn2 rn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn2Var;
        }

        @Override // com.baidu.tieba.ko2.f
        public void d(ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ko2Var) == null) && this.a.b != null) {
                this.a.b.onStart();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ko2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn2 a;

        public f(rn2 rn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn2Var;
        }

        @Override // com.baidu.tieba.ko2.c
        public void c(ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ko2Var) == null) && this.a.b != null) {
                this.a.b.onPause();
            }
        }
    }

    public rn2() {
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

    @Override // com.baidu.tieba.cr2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cr2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ys2 ys2Var = this.d;
            if (ys2Var != null) {
                return ys2Var.z;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zs3
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return o().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.zs3
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return o().getDuration();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.zs3
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ko2 ko2Var = this.a;
            if (ko2Var != null && ko2Var.isEnd()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zs3
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ko2 ko2Var = this.a;
            if (ko2Var != null && ko2Var.isPlaying()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !TextUtils.isEmpty(this.e)) {
            dr2.a(this);
        }
    }

    @Override // com.baidu.tieba.cr2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ko2 ko2Var = this.a;
            if (ko2Var != null && ko2Var.onBackPressed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cr2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ko2 ko2Var = this.a;
            if (ko2Var != null) {
                ko2Var.stop();
                this.a = null;
            }
            dr2.k(this);
        }
    }

    @Override // com.baidu.tieba.zs3
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
            ys2 ys2Var = this.d;
            if (ys2Var != null && !TextUtils.isEmpty(ys2Var.y)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zs3
    public void resume() {
        ko2 ko2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f && (ko2Var = this.a) != null) {
            ko2Var.resume();
        }
    }

    @Override // com.baidu.tieba.zs3
    public void stop() {
        ko2 ko2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (ko2Var = this.a) != null) {
            ko2Var.stop();
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.zs3
    public void a(FrameLayout frameLayout) {
        ko2 ko2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) && (ko2Var = this.a) != null) {
            ko2Var.a(frameLayout);
        }
    }

    @Override // com.baidu.tieba.zs3
    public void d(boolean z) {
        ko2 ko2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (ko2Var = this.a) != null) {
            ko2Var.d(z);
        }
    }

    @Override // com.baidu.tieba.zs3
    public void g(ts3 ts3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ts3Var) == null) {
            this.b = ts3Var;
        }
    }

    @Override // com.baidu.tieba.zs3
    public void h(vr3 vr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vr3Var) == null) {
            ys2 p = p(vr3Var);
            this.d = p;
            ko2 ko2Var = this.a;
            if (ko2Var != null) {
                ko2Var.o(p);
            }
        }
    }

    @Override // com.baidu.tieba.zs3
    public void mute(boolean z) {
        ko2 ko2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (ko2Var = this.a) != null) {
            ko2Var.mute(z);
        }
    }

    @Override // com.baidu.tieba.zs3
    public /* bridge */ /* synthetic */ zs3 e(Context context, @NonNull vr3 vr3Var) {
        n(context, vr3Var);
        return this;
    }

    public rn2 n(Context context, @NonNull vr3 vr3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, vr3Var)) == null) {
            this.c = context;
            ys2 p = p(vr3Var);
            this.d = p;
            this.e = p.j;
            o();
            m();
            return this;
        }
        return (rn2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.cr2
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

    public ys2 p(vr3 vr3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, vr3Var)) == null) {
            ys2 ys2Var = new ys2();
            ys2Var.j = "SwanAdPlayer";
            ys2Var.b = "SwanAdPlayer";
            ys2Var.o = vr3Var.f;
            ys2Var.k = vr3Var.b;
            ys2Var.x = vr3Var.o;
            ys2Var.I = vr3Var.z;
            ys2Var.E = vr3Var.v;
            ys2Var.y = vr3Var.p;
            return ys2Var;
        }
        return (ys2) invokeL.objValue;
    }

    public ko2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                ko2 C0 = ln2.C0();
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
        return (ko2) invokeV.objValue;
    }
}
