package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.jv2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes7.dex */
public class qu2 implements yz3, by2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jv2 a;
    public sz3 b;
    public Context c;
    public xz2 d;
    public String e;
    public boolean f;
    public boolean g;

    @Override // com.baidu.tieba.by2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.by2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements jv2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu2 a;

        public a(qu2 qu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu2Var;
        }

        @Override // com.baidu.tieba.jv2.a
        public void b(jv2 jv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv2Var) == null) && this.a.b != null) {
                this.a.b.onCompletion();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements jv2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu2 a;

        public b(qu2 qu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu2Var;
        }

        @Override // com.baidu.tieba.jv2.b
        public boolean f(jv2 jv2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, jv2Var, i, i2)) == null) {
                if (this.a.b != null && this.a.b.onError()) {
                    return true;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements jv2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu2 a;

        public c(qu2 qu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu2Var;
        }

        @Override // com.baidu.tieba.jv2.d
        public void e(jv2 jv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv2Var) == null) && this.a.b != null) {
                this.a.b.onPrepared();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements jv2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu2 a;

        public d(qu2 qu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu2Var;
        }

        @Override // com.baidu.tieba.jv2.e
        public void a(jv2 jv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv2Var) == null) && this.a.b != null) {
                this.a.b.onResume();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements jv2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu2 a;

        public e(qu2 qu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu2Var;
        }

        @Override // com.baidu.tieba.jv2.f
        public void d(jv2 jv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv2Var) == null) && this.a.b != null) {
                this.a.b.onStart();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements jv2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu2 a;

        public f(qu2 qu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu2Var;
        }

        @Override // com.baidu.tieba.jv2.c
        public void c(jv2 jv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv2Var) == null) && this.a.b != null) {
                this.a.b.onPause();
            }
        }
    }

    public qu2() {
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

    @Override // com.baidu.tieba.by2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.by2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.by2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            xz2 xz2Var = this.d;
            if (xz2Var != null) {
                return xz2Var.z;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yz3
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return o().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yz3
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return o().getDuration();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yz3
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            jv2 jv2Var = this.a;
            if (jv2Var != null && jv2Var.isEnd()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yz3
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            jv2 jv2Var = this.a;
            if (jv2Var != null && jv2Var.isPlaying()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !TextUtils.isEmpty(this.e)) {
            cy2.a(this);
        }
    }

    @Override // com.baidu.tieba.by2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            jv2 jv2Var = this.a;
            if (jv2Var != null && jv2Var.onBackPressed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.by2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            jv2 jv2Var = this.a;
            if (jv2Var != null) {
                jv2Var.stop();
                this.a = null;
            }
            cy2.k(this);
        }
    }

    @Override // com.baidu.tieba.yz3
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
            xz2 xz2Var = this.d;
            if (xz2Var != null && !TextUtils.isEmpty(xz2Var.y)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yz3
    public void resume() {
        jv2 jv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f && (jv2Var = this.a) != null) {
            jv2Var.resume();
        }
    }

    @Override // com.baidu.tieba.yz3
    public void stop() {
        jv2 jv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (jv2Var = this.a) != null) {
            jv2Var.stop();
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.yz3
    public void a(FrameLayout frameLayout) {
        jv2 jv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) && (jv2Var = this.a) != null) {
            jv2Var.a(frameLayout);
        }
    }

    @Override // com.baidu.tieba.yz3
    public void d(boolean z) {
        jv2 jv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (jv2Var = this.a) != null) {
            jv2Var.d(z);
        }
    }

    @Override // com.baidu.tieba.yz3
    public void g(sz3 sz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sz3Var) == null) {
            this.b = sz3Var;
        }
    }

    @Override // com.baidu.tieba.yz3
    public void h(uy3 uy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, uy3Var) == null) {
            xz2 p = p(uy3Var);
            this.d = p;
            jv2 jv2Var = this.a;
            if (jv2Var != null) {
                jv2Var.o(p);
            }
        }
    }

    @Override // com.baidu.tieba.yz3
    public void mute(boolean z) {
        jv2 jv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (jv2Var = this.a) != null) {
            jv2Var.mute(z);
        }
    }

    @Override // com.baidu.tieba.yz3
    public /* bridge */ /* synthetic */ yz3 e(Context context, @NonNull uy3 uy3Var) {
        n(context, uy3Var);
        return this;
    }

    public qu2 n(Context context, @NonNull uy3 uy3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, uy3Var)) == null) {
            this.c = context;
            xz2 p = p(uy3Var);
            this.d = p;
            this.e = p.j;
            o();
            m();
            return this;
        }
        return (qu2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.by2
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

    public xz2 p(uy3 uy3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, uy3Var)) == null) {
            xz2 xz2Var = new xz2();
            xz2Var.j = "SwanAdPlayer";
            xz2Var.b = "SwanAdPlayer";
            xz2Var.o = uy3Var.f;
            xz2Var.k = uy3Var.b;
            xz2Var.x = uy3Var.o;
            xz2Var.I = uy3Var.z;
            xz2Var.E = uy3Var.v;
            xz2Var.y = uy3Var.p;
            return xz2Var;
        }
        return (xz2) invokeL.objValue;
    }

    public jv2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                jv2 C0 = ku2.C0();
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
        return (jv2) invokeV.objValue;
    }
}
