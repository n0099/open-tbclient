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
/* loaded from: classes6.dex */
public abstract class iu0 implements tw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public final HashMap<String, String> d;
    @NonNull
    public final xw0 e;

    public abstract void A();

    public abstract void B(String str, Object obj);

    public void D(qu0 qu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qu0Var) == null) {
        }
    }

    public abstract void E(boolean z);

    public abstract void F(String str, String str2);

    public void G(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    public abstract void H(@Nullable String str);

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public abstract void J(float f);

    public abstract void L(String str, @NonNull HashMap<String, String> hashMap);

    public abstract void M(int i);

    public abstract void S(@Nullable String str);

    @Nullable
    public abstract View c();

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract void m(boolean z);

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
        }
    }

    @Override // com.baidu.tieba.tw0
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public abstract void y(int i, int i2);

    public void z(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
        }
    }

    public iu0() {
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
        this.e = yw0.c().b();
        u("VideoKernel: " + getClass().getSimpleName() + " Created, HashCode = " + System.identityHashCode(this));
    }

    public void C(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) && hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                this.d.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            ix0.b(AbsVideoKernel.TAG, String.format("video kernel [%s]: %s ", "AbsVideoKernel@" + System.identityHashCode(this), str));
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && !TextUtils.isEmpty(str)) {
            u("setUserAgent = " + str);
            this.d.put("User-Agent", str);
        }
    }

    public void a(@NonNull pv0 pv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pv0Var) == null) {
            this.e.b(pv0Var);
        }
    }

    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.b = str;
            n(PlayerStatus.PREPARING);
            A();
            O();
        }
    }

    public boolean l(@NonNull PlayerStatus... playerStatusArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, playerStatusArr)) == null) {
            return this.e.e(playerStatusArr);
        }
        return invokeL.booleanValue;
    }

    public void n(PlayerStatus playerStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, playerStatus) == null) {
            this.e.g(playerStatus);
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            y(i, 3);
        }
    }

    public void N(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, str, z) == null) {
            this.b = str;
            if (!TextUtils.isEmpty(str) && z) {
                this.c = this.b;
                u("setDataSourceAndPrepare " + this.b);
                n(PlayerStatus.PREPARING);
                A();
            }
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            u("start()" + this.b);
            if (TextUtils.isEmpty(this.b)) {
                this.b = "";
            } else {
                v();
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            u("stop");
            this.c = null;
            n(PlayerStatus.STOP);
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            u("stopPlayback");
            this.c = null;
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.e.h();
        }
    }

    public PlayerStatus i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.e.c();
        }
        return (PlayerStatus) invokeV.objValue;
    }

    @NonNull
    public xw0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.e;
        }
        return (xw0) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tw0
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            u("onInit");
            View c = c();
            if (c != null) {
                c.setBackground(null);
            }
        }
    }

    @Override // com.baidu.tieba.tw0
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            u("onRelease");
            ys0.a(c());
            this.e.f();
            this.c = null;
            this.b = "";
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.c = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            u(DownloadStatisticConstants.UBC_TYPE_PAUSE);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            u("prepare");
            if (!PlayerStatus.isActiveStatus(i()) && !TextUtils.isEmpty(this.b)) {
                n(PlayerStatus.PREPARING);
                A();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && !TextUtils.equals(this.c, this.b) && !TextUtils.isEmpty(this.b)) {
            n(PlayerStatus.PREPARING);
            A();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            u(DownloadStatisticConstants.UBC_TYPE_RESUME);
        }
    }

    public void q(int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048613, this, i, i2, obj) == null) && 701 != i && 702 != i) {
            if (946 == i) {
                this.a = i2;
            } else if (924 != i && 5000 == i && (obj instanceof String)) {
                String str = (String) obj;
            }
        }
    }
}
