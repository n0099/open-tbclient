package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes8.dex */
public class vp2 implements ev3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vp2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.ev3
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return rp2.n().a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ev3
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return rp2.y0().c();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ev3
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String i = rp2.h0().i(rp2.c());
            if (TextUtils.isEmpty(i)) {
                return ek3.r();
            }
            return i;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ev3
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                return "";
            }
            return c0.X().k1().optString(TiebaStatic.Params.EQID, "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ev3
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            k63 M = k63.M();
            if (M != null) {
                return M.b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ev3
    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            k63 M = k63.M();
            if (M != null) {
                return M.P();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ev3
    public String getScene() {
        InterceptResult invokeV;
        hr2.a X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            k63 c0 = k63.c0();
            if (c0 != null && (X = c0.X()) != null) {
                return X.U();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ev3
    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return wm1.a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ev3
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (xr2.V().getActivity() != null) {
                return tj3.e(xr2.V().getActivity());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ev3
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return ((Integer) xr2.V().y().second).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ev3
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return ((Integer) xr2.V().y().first).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ev3
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return ek3.r();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ev3
    public JSONObject n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            k63 c0 = k63.c0();
            JSONObject jSONObject = new JSONObject();
            if (c0 != null) {
                return c0.X().N();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ev3
    public boolean b(Context context, Intent intent, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, intent, str, str2, str3)) == null) {
            if (rp2.a().d()) {
                return rp2.a().b(context, intent, str, str2, str3);
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev3
    public boolean d(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull lu3 lu3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, jSONObject, swanAppDownloadType, lu3Var)) == null) {
            return rp2.d().d(context, jSONObject, swanAppDownloadType, lu3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev3
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return rp2.q().a().getCookie(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ev3
    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return ji3.b(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ev3
    public boolean o(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view2)) == null) {
            if (xr2.V().getActivity() != null) {
                return tj3.q(xr2.V().getActivity(), view2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ev3
    public Uri l(@NonNull Context context, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, context, file)) == null) {
            return hk3.a(context, file);
        }
        return (Uri) invokeLL.objValue;
    }
}
