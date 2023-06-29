package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.tieba.ix0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"KotlinPropertyAccess"})
/* loaded from: classes7.dex */
public abstract class ru0 extends eu0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean G;
    public transient /* synthetic */ FieldHolder $fh;
    public fx0 A;
    public ix0 B;
    public ex0 C;
    public String D;
    public boolean E;
    public final SimpleArrayMap<Class<? extends Object>, Object> F;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948133980, "Lcom/baidu/tieba/ru0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948133980, "Lcom/baidu/tieba/ru0;");
        }
    }

    @Override // com.baidu.tieba.eu0
    public void G0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
        }
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean T0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            return true;
        }
        return invokeZ.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements ix0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public long c;
        public final /* synthetic */ ru0 d;

        public a(ru0 ru0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ru0Var;
            this.c = 0L;
        }

        @Override // com.baidu.tieba.ix0.a
        public void onOrientationChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && !ru0.W0()) {
                ru0 ru0Var = this.d;
                if (ru0Var.e == null || !ru0Var.N0() || this.d.U0() || ix0.f(du0.b())) {
                    return;
                }
                if (!this.d.V0()) {
                    this.a = false;
                    if (ix0.d(i)) {
                        this.b = true;
                    }
                    if (this.b && ix0.c(i) && this.d.e.getVisibility() == 0 && System.currentTimeMillis() - this.c > 1000) {
                        this.c = System.currentTimeMillis();
                        this.d.c1(0);
                        this.b = false;
                        return;
                    }
                    return;
                }
                this.b = false;
                if (ix0.e(i)) {
                    this.a = true;
                    z11.a(this.d.getActivity(), true);
                } else if (ix0.c(i)) {
                    this.a = true;
                    z11.a(this.d.getActivity(), false);
                } else if (ix0.d(i) && this.a && System.currentTimeMillis() - this.c > 1000) {
                    this.c = System.currentTimeMillis();
                    this.d.d1(0);
                    this.a = false;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ru0(@NonNull xx0 xx0Var, @Nullable Context context) {
        super(xx0Var, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xx0Var, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((xx0) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = PlayerConstant.HALF_MODE;
        this.F = new SimpleArrayMap<>();
        t11.c().b();
    }

    public static boolean W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return G;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.eu0
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m = new pv0();
        }
    }

    public void O0() {
        ix0 ix0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (ix0Var = this.B) == null) {
            return;
        }
        this.E = false;
        ix0Var.disable();
    }

    @Override // com.baidu.tieba.eu0
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            S0();
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.B.canDetectOrientation()) {
            this.E = this.B.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.eu0
    @NonNull
    /* renamed from: Q0 */
    public pv0 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (pv0) this.m;
        }
        return (pv0) invokeV.objValue;
    }

    @NonNull
    public u11 R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return v11.a;
        }
        return (u11) invokeV.objValue;
    }

    public boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return TextUtils.equals(this.D, PlayerConstant.FLOATING_MODE);
        }
        return invokeV.booleanValue;
    }

    public boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return TextUtils.equals(this.D, PlayerConstant.FULL_MODE);
        }
        return invokeV.booleanValue;
    }

    public boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ix0 ix0Var = this.B;
            if (ix0Var != null && this.E) {
                return ix0.e(ix0Var.b());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Z0(!G);
        }
    }

    @Override // com.baidu.tieba.eu0
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.g0();
            this.F.clear();
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.A = new lx0(this);
            ix0 ix0Var = new ix0(du0.b(), 3);
            this.B = ix0Var;
            if (ix0Var.canDetectOrientation()) {
                this.E = true;
                this.B.disable();
                this.B.g(new a(this));
            }
            this.C = new mx0(this);
        }
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (T0(true)) {
                k21.d(getActivity(), true);
            }
            i21.b(UniversalPlayer.TAG, "player start switchToFull");
            y().t();
            this.C.switchToFullStyle();
            q0(ow0.w(LayerEvent.ACTION_SWITCH_FULL));
            y().z();
        }
    }

    public void Y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.D = PlayerConstant.FULL_MODE;
            } else {
                this.D = PlayerConstant.HALF_MODE;
            }
        }
    }

    public void Z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            G = z;
            if (!z) {
                P0();
            }
        }
    }

    public void c1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            b1();
        }
    }

    public void d1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (T0(false)) {
                k21.d(getActivity(), false);
            }
            y().u();
            i21.b(UniversalPlayer.TAG, "player start switchToHalf");
            this.C.switchToNormalStyle();
            q0(ow0.w(LayerEvent.ACTION_SWITCH_HALF));
            y().A();
        }
    }
}
