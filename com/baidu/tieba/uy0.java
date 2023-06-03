package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class uy0 implements k11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public final HashMap<String, String> d;
    @NonNull
    public final o11 e;

    public abstract void A(int i, int i2);

    public void B(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    public abstract void C();

    public abstract void D(String str, Object obj);

    public void F(cz0 cz0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cz0Var) == null) {
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

    public abstract void N(String str, @NonNull HashMap<String, String> hashMap);

    public abstract void O(int i);

    public abstract void U(@Nullable String str);

    @Nullable
    public abstract View c();

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int j();

    public abstract int m();

    public abstract void o(boolean z);

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    @Override // com.baidu.tieba.k11
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public uy0() {
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
        this.e = p11.c().b();
        w("VideoKernel: " + getClass().getSimpleName() + " Created, HashCode = " + System.identityHashCode(this));
    }

    public void E(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, hashMap) == null) && hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                this.d.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            e21.b(AbsVideoKernel.TAG, String.format("video kernel [%s]: %s ", "AbsVideoKernel@" + System.identityHashCode(this), str));
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && !TextUtils.isEmpty(str)) {
            w("setUserAgent = " + str);
            this.d.put("User-Agent", str);
        }
    }

    public void a(@NonNull b01 b01Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, b01Var) == null) {
            this.e.b(b01Var);
        }
    }

    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.b = str;
            p(PlayerStatus.PREPARING);
            C();
            Q();
        }
    }

    public boolean n(@NonNull PlayerStatus... playerStatusArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, playerStatusArr)) == null) {
            return this.e.e(playerStatusArr);
        }
        return invokeL.booleanValue;
    }

    public void p(PlayerStatus playerStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, playerStatus) == null) {
            this.e.g(playerStatus);
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            A(i, 3);
        }
    }

    public void P(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) {
            this.b = str;
            if (!TextUtils.isEmpty(str) && z) {
                this.c = this.b;
                w("setDataSourceAndPrepare " + this.b);
                p(PlayerStatus.PREPARING);
                C();
            }
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
            w("stop");
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

    public PlayerStatus i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.e.c();
        }
        return (PlayerStatus) invokeV.objValue;
    }

    @NonNull
    public o11 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.e;
        }
        return (o11) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k11
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

    @Override // com.baidu.tieba.k11
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            w("onRelease");
            kx0.a(c());
            this.e.f();
            this.c = null;
            this.b = "";
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.c = null;
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            w(DownloadStatisticConstants.UBC_TYPE_PAUSE);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            w("prepare");
            if (!PlayerStatus.isActiveStatus(i()) && !TextUtils.isEmpty(this.b)) {
                p(PlayerStatus.PREPARING);
                C();
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && !TextUtils.equals(this.c, this.b) && !TextUtils.isEmpty(this.b)) {
            p(PlayerStatus.PREPARING);
            C();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            w(DownloadStatisticConstants.UBC_TYPE_RESUME);
        }
    }

    public void s(int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048617, this, i, i2, obj) == null) && 701 != i && 702 != i) {
            if (946 == i) {
                this.a = i2;
            } else if (924 != i && 5000 == i && (obj instanceof String)) {
                String str = (String) obj;
            }
        }
    }
}
