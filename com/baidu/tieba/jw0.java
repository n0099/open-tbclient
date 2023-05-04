package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.tieba.qv0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class jw0 extends cz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> d;
    public final HashMap<String, String> e;

    public jw0() {
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

    @Override // com.baidu.tieba.wv0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new int[]{2, 4, 6};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cz0
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
            return String.valueOf(i().C());
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
            return String.valueOf(i().D());
        }
        return (String) invokeV.objValue;
    }

    public final String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!(i() instanceof cs0) || ((cs0) i()).l1() != 0) {
                return "0";
            }
            return "1";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cz0, com.baidu.tieba.wv0
    public void a(@NonNull vu0 vu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vu0Var) == null) {
            p(vu0Var);
        }
    }

    @Override // com.baidu.tieba.cz0, com.baidu.tieba.wv0
    public void d(@NonNull vu0 vu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vu0Var) == null) {
            p(vu0Var);
        }
    }

    @Override // com.baidu.tieba.cz0, com.baidu.tieba.wv0
    public void q(@NonNull vu0 vu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vu0Var) == null) {
            p(vu0Var);
        }
    }

    public final void p(@NonNull vu0 vu0Var) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, vu0Var) != null) || !w()) {
            return;
        }
        jy0 jy0Var = new jy0();
        jy0Var.h(vu0.a(vu0Var));
        jy0Var.b(v());
        jy0Var.c(s());
        jy0Var.d(r());
        jy0Var.e(u());
        jy0Var.g(t());
        cs0 cs0Var = (cs0) i();
        if (cs0Var == null) {
            o1 = null;
        } else {
            o1 = cs0Var.o1();
        }
        if (o1 != null) {
            String extLog = o1.getExtLog();
            String str = this.d.get(extLog);
            String str2 = this.e.get(extLog);
            if (str == null) {
                JSONObject c = z01.c(extLog);
                String optString = c.optString("ad_extra_param");
                String optString2 = c.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                this.d.put(extLog, optString);
                this.e.put(extLog, optString2);
                str2 = optString2;
                str = optString;
            }
            jy0Var.f(str);
            jy0Var.a(str2);
        }
        qv0.a.a().a(jy0Var);
        qv0.a.a().b(jy0Var);
        vu0 vu0Var2 = jy0Var.a;
        if (vu0Var2 != null) {
            vu0Var2.o();
        }
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (i() == null) {
                return "0";
            }
            if (i().K() != null && i().K().e > 0) {
                return String.valueOf(i().K().e);
            }
            return String.valueOf(i().r());
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
            if (!(i() instanceof cs0)) {
                return false;
            }
            cs0 cs0Var = (cs0) i();
            if (cs0Var.o1() == null || TextUtils.isEmpty(cs0Var.o1().getExtLog())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
