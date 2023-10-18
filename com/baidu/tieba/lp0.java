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
import com.baidu.tieba.cs0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"KotlinPropertyAccess"})
/* loaded from: classes7.dex */
public abstract class lp0 extends yo0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean G;
    public transient /* synthetic */ FieldHolder $fh;
    public zr0 A;
    public cs0 B;
    public yr0 C;
    public String D;
    public boolean E;
    public final SimpleArrayMap<Class<? extends Object>, Object> F;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947950429, "Lcom/baidu/tieba/lp0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947950429, "Lcom/baidu/tieba/lp0;");
        }
    }

    @Override // com.baidu.tieba.yo0
    public void E0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
        }
    }

    public boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public abstract jq0 N0();

    public boolean O0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            return true;
        }
        return invokeZ.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements cs0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public long c;
        public final /* synthetic */ lp0 d;

        public a(lp0 lp0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = lp0Var;
            this.c = 0L;
        }

        @Override // com.baidu.tieba.cs0.a
        public void onOrientationChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && !lp0.R0()) {
                lp0 lp0Var = this.d;
                if (lp0Var.e == null || !lp0Var.K0() || this.d.P0() || cs0.f(xo0.b())) {
                    return;
                }
                if (!this.d.Q0()) {
                    this.a = false;
                    if (cs0.d(i)) {
                        this.b = true;
                    }
                    if (this.b && cs0.c(i) && this.d.e.getVisibility() == 0 && System.currentTimeMillis() - this.c > 1000) {
                        this.c = System.currentTimeMillis();
                        this.d.X0(0);
                        this.b = false;
                        return;
                    }
                    return;
                }
                this.b = false;
                if (cs0.e(i)) {
                    this.a = true;
                    kw0.a(this.d.m(), true);
                } else if (cs0.c(i)) {
                    this.a = true;
                    kw0.a(this.d.m(), false);
                } else if (cs0.d(i) && this.a && System.currentTimeMillis() - this.c > 1000) {
                    this.c = System.currentTimeMillis();
                    this.d.Y0(0);
                    this.a = false;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lp0(@NonNull qs0 qs0Var, @Nullable Context context) {
        super(qs0Var, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qs0Var, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qs0) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = PlayerConstant.HALF_MODE;
        this.F = new SimpleArrayMap<>();
        hw0.c().b();
    }

    public static boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return G;
        }
        return invokeV.booleanValue;
    }

    public void L0() {
        cs0 cs0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (cs0Var = this.B) == null) {
            return;
        }
        this.E = false;
        cs0Var.disable();
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.B.canDetectOrientation()) {
            this.E = this.B.a();
        }
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return TextUtils.equals(this.D, PlayerConstant.FLOATING_MODE);
        }
        return invokeV.booleanValue;
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return TextUtils.equals(this.D, PlayerConstant.FULL_MODE);
        }
        return invokeV.booleanValue;
    }

    public boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            cs0 cs0Var = this.B;
            if (cs0Var != null && this.E) {
                return cs0.e(cs0Var.b());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            U0(!G);
        }
    }

    @Override // com.baidu.tieba.yo0
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.e0();
            this.F.clear();
        }
    }

    public void T0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.D = PlayerConstant.FULL_MODE;
            } else {
                this.D = PlayerConstant.HALF_MODE;
            }
        }
    }

    public void U0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            G = z;
            if (!z) {
                M0();
            }
        }
    }

    public void X0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            W0();
        }
    }

    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (O0(true)) {
                tw0.d(m(), true);
            }
            rw0.b(UniversalPlayer.TAG, "player start switchToFull");
            N0().t();
            this.C.switchToFullStyle();
            o0(ir0.x(LayerEvent.ACTION_SWITCH_FULL));
            N0().z();
        }
    }

    public void Y0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            if (O0(false)) {
                tw0.d(m(), false);
            }
            N0().u();
            rw0.b(UniversalPlayer.TAG, "player start switchToHalf");
            this.C.switchToNormalStyle();
            o0(ir0.x(LayerEvent.ACTION_SWITCH_HALF));
            N0().A();
        }
    }
}
