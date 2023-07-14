package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.bw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes6.dex */
public class iv2 implements q04, ty2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bw2 a;
    public k04 b;
    public Context c;
    public p03 d;
    public String e;
    public boolean f;
    public boolean g;

    @Override // com.baidu.tieba.ty2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements bw2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv2 a;

        public a(iv2 iv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iv2Var;
        }

        @Override // com.baidu.tieba.bw2.a
        public void b(bw2 bw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw2Var) == null) && this.a.b != null) {
                this.a.b.onCompletion();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements bw2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv2 a;

        public b(iv2 iv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iv2Var;
        }

        @Override // com.baidu.tieba.bw2.b
        public boolean f(bw2 bw2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bw2Var, i, i2)) == null) {
                if (this.a.b != null && this.a.b.onError()) {
                    return true;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements bw2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv2 a;

        public c(iv2 iv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iv2Var;
        }

        @Override // com.baidu.tieba.bw2.d
        public void e(bw2 bw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw2Var) == null) && this.a.b != null) {
                this.a.b.onPrepared();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements bw2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv2 a;

        public d(iv2 iv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iv2Var;
        }

        @Override // com.baidu.tieba.bw2.e
        public void a(bw2 bw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw2Var) == null) && this.a.b != null) {
                this.a.b.onResume();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements bw2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv2 a;

        public e(iv2 iv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iv2Var;
        }

        @Override // com.baidu.tieba.bw2.f
        public void d(bw2 bw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw2Var) == null) && this.a.b != null) {
                this.a.b.onStart();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements bw2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv2 a;

        public f(iv2 iv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iv2Var;
        }

        @Override // com.baidu.tieba.bw2.c
        public void c(bw2 bw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw2Var) == null) && this.a.b != null) {
                this.a.b.onPause();
            }
        }
    }

    public iv2() {
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

    @Override // com.baidu.tieba.ty2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            p03 p03Var = this.d;
            if (p03Var != null) {
                return p03Var.z;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q04
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return o().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.q04
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return o().getDuration();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.q04
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            bw2 bw2Var = this.a;
            if (bw2Var != null && bw2Var.isEnd()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q04
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            bw2 bw2Var = this.a;
            if (bw2Var != null && bw2Var.isPlaying()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && !TextUtils.isEmpty(this.e)) {
            uy2.a(this);
        }
    }

    @Override // com.baidu.tieba.ty2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            bw2 bw2Var = this.a;
            if (bw2Var != null) {
                bw2Var.stop();
                this.a = null;
            }
            uy2.k(this);
        }
    }

    @Override // com.baidu.tieba.q04
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
            p03 p03Var = this.d;
            if (p03Var != null && !TextUtils.isEmpty(p03Var.y)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q04
    public void resume() {
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f && (bw2Var = this.a) != null) {
            bw2Var.resume();
        }
    }

    @Override // com.baidu.tieba.q04
    public void stop() {
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (bw2Var = this.a) != null) {
            bw2Var.stop();
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.q04
    public void a(FrameLayout frameLayout) {
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) && (bw2Var = this.a) != null) {
            bw2Var.a(frameLayout);
        }
    }

    @Override // com.baidu.tieba.q04
    public void d(boolean z) {
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (bw2Var = this.a) != null) {
            bw2Var.d(z);
        }
    }

    @Override // com.baidu.tieba.q04
    public void g(k04 k04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, k04Var) == null) {
            this.b = k04Var;
        }
    }

    @Override // com.baidu.tieba.q04
    public void h(mz3 mz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mz3Var) == null) {
            p03 p = p(mz3Var);
            this.d = p;
            bw2 bw2Var = this.a;
            if (bw2Var != null) {
                bw2Var.o(p);
            }
        }
    }

    @Override // com.baidu.tieba.q04
    public void mute(boolean z) {
        bw2 bw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (bw2Var = this.a) != null) {
            bw2Var.mute(z);
        }
    }

    @Override // com.baidu.tieba.q04
    public /* bridge */ /* synthetic */ q04 e(Context context, @NonNull mz3 mz3Var) {
        n(context, mz3Var);
        return this;
    }

    public iv2 n(Context context, @NonNull mz3 mz3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, mz3Var)) == null) {
            this.c = context;
            p03 p = p(mz3Var);
            this.d = p;
            this.e = p.j;
            o();
            m();
            return this;
        }
        return (iv2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ty2
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

    public p03 p(mz3 mz3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, mz3Var)) == null) {
            p03 p03Var = new p03();
            p03Var.j = "SwanAdPlayer";
            p03Var.b = "SwanAdPlayer";
            p03Var.o = mz3Var.f;
            p03Var.k = mz3Var.b;
            p03Var.x = mz3Var.o;
            p03Var.I = mz3Var.z;
            p03Var.E = mz3Var.v;
            p03Var.y = mz3Var.p;
            return p03Var;
        }
        return (p03) invokeL.objValue;
    }

    public bw2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                bw2 C0 = cv2.C0();
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
        return (bw2) invokeV.objValue;
    }
}
