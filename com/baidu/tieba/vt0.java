package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class vt0 implements lw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public final HashMap<String, String> d;
    @NonNull
    public final pw0 e;

    public vt0() {
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
        this.d = new HashMap<>();
        this.e = qw0.c().b();
        w("VideoKernel: " + getClass().getSimpleName() + " Created, HashCode = " + System.identityHashCode(this));
    }

    public abstract void A(int i, int i2);

    public void B(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    public abstract void C();

    public abstract void D(String str, Object obj);

    public void E(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, hashMap) == null) || hashMap == null) {
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            this.d.put(entry.getKey(), entry.getValue());
        }
    }

    public void F(du0 du0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, du0Var) == null) {
        }
    }

    public abstract void G(boolean z);

    public abstract void H(String str, String str2);

    public void I(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
        }
    }

    public abstract void J(@Nullable String str);

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    public abstract void L(float f);

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        w("setUserAgent = " + str);
        this.d.put("User-Agent", str);
    }

    public abstract void N(String str, @NonNull HashMap<String, String> hashMap);

    public abstract void O(int i);

    public void P(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) {
            this.b = str;
            if (TextUtils.isEmpty(str) || !z) {
                return;
            }
            this.c = this.b;
            w("setDataSourceAndPrepare " + this.b);
            p(PlayerStatus.PREPARING);
            C();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            w("start()" + this.b);
            if (TextUtils.isEmpty(this.b)) {
                this.b = "";
            } else {
                x();
            }
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            w(IntentConfig.STOP);
            this.c = null;
            p(PlayerStatus.STOP);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            w("stopPlayback");
            this.c = null;
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.e.h();
        }
    }

    public abstract void U(@Nullable String str);

    public void a(@NonNull cv0 cv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cv0Var) == null) {
            this.e.b(cv0Var);
        }
    }

    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.b = str;
        p(PlayerStatus.PREPARING);
        C();
        Q();
    }

    @Nullable
    public abstract View c();

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public PlayerStatus i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.e.c() : (PlayerStatus) invokeV.objValue;
    }

    public abstract int j();

    @NonNull
    public pw0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.e : (pw0) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public abstract int m();

    public boolean n(@NonNull PlayerStatus... playerStatusArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, playerStatusArr)) == null) ? this.e.e(playerStatusArr) : invokeL.booleanValue;
    }

    public abstract void o(boolean z);

    @Override // com.baidu.tieba.lw0
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            w("onInit");
            View c = c();
            if (c != null) {
                c.setBackground(null);
            }
        }
    }

    @Override // com.baidu.tieba.lw0
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            w("onRelease");
            ls0.a(c());
            this.e.f();
            this.c = null;
            this.b = "";
        }
    }

    public void p(PlayerStatus playerStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, playerStatus) == null) {
            this.e.g(playerStatus);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.c = null;
        }
    }

    public void s(int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048617, this, i, i2, obj) == null) || 701 == i || 702 == i) {
            return;
        }
        if (946 == i) {
            this.a = i2;
        } else if (924 != i && 5000 == i && (obj instanceof String)) {
            String str = (String) obj;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            w("pause");
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            w("prepare");
            if (PlayerStatus.isActiveStatus(i()) || TextUtils.isEmpty(this.b)) {
                return;
            }
            p(PlayerStatus.PREPARING);
            C();
        }
    }

    @Override // com.baidu.tieba.lw0
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            ex0.b(AbsVideoKernel.TAG, String.format("video kernel [%s]: %s ", "AbsVideoKernel@" + System.identityHashCode(this), str));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || TextUtils.equals(this.c, this.b) || TextUtils.isEmpty(this.b)) {
            return;
        }
        p(PlayerStatus.PREPARING);
        C();
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            w("resume");
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            A(i, 3);
        }
    }
}
