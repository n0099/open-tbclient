package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.tieba.gt0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zt0 extends ow0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> d;
    public final HashMap<String, String> e;

    public zt0() {
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
        this.e = new HashMap<>();
    }

    @Override // com.baidu.tieba.mt0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new int[]{2, 4, 6};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ow0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.m();
            this.d.clear();
            this.e.clear();
        }
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (i() == null) {
                return "0";
            }
            return String.valueOf(i().D());
        }
        return (String) invokeV.objValue;
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (i() == null) {
                return "0";
            }
            return String.valueOf(i().E());
        }
        return (String) invokeV.objValue;
    }

    public final String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!(i() instanceof tp0) || ((tp0) i()).g1() != 0) {
                return "0";
            }
            return "1";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ow0, com.baidu.tieba.mt0
    public void a(@NonNull ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ms0Var) == null) {
            p(ms0Var);
        }
    }

    @Override // com.baidu.tieba.ow0, com.baidu.tieba.mt0
    public void d(@NonNull ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ms0Var) == null) {
            p(ms0Var);
        }
    }

    @Override // com.baidu.tieba.ow0, com.baidu.tieba.mt0
    public void r(@NonNull ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ms0Var) == null) {
            p(ms0Var);
        }
    }

    public final void p(@NonNull ms0 ms0Var) {
        BdVideoSeries j1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, ms0Var) != null) || !w()) {
            return;
        }
        vv0 vv0Var = new vv0();
        vv0Var.h(ms0.a(ms0Var));
        vv0Var.b(v());
        vv0Var.c(s());
        vv0Var.d(q());
        vv0Var.e(u());
        vv0Var.g(t());
        tp0 tp0Var = (tp0) i();
        if (tp0Var == null) {
            j1 = null;
        } else {
            j1 = tp0Var.j1();
        }
        if (j1 != null) {
            String extLog = j1.getExtLog();
            String str = this.d.get(extLog);
            String str2 = this.e.get(extLog);
            if (str == null) {
                JSONObject c = oy0.c(extLog);
                String optString = c.optString("ad_extra_param");
                String optString2 = c.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                this.d.put(extLog, optString);
                this.e.put(extLog, optString2);
                str2 = optString2;
                str = optString;
            }
            vv0Var.f(str);
            vv0Var.a(str2);
        }
        gt0.a.a().a(vv0Var);
        gt0.a.a().b(vv0Var);
        ms0 ms0Var2 = vv0Var.a;
        if (ms0Var2 != null) {
            ms0Var2.p();
        }
    }

    public final String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (i() == null) {
                return "0";
            }
            if (i().K() != null && i().K().e > 0) {
                return String.valueOf(i().K().e);
            }
            return String.valueOf(i().s());
        }
        return (String) invokeV.objValue;
    }

    public final String u() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (i() == null) {
                return "0";
            }
            if (i().K() != null) {
                i = i().K().d;
            } else {
                i = 0;
            }
            return String.valueOf(i);
        }
        return (String) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!(i() instanceof tp0)) {
                return false;
            }
            tp0 tp0Var = (tp0) i();
            if (tp0Var.j1() == null || TextUtils.isEmpty(tp0Var.j1().getExtLog())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
