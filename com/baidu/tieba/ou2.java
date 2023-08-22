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
import com.baidu.tieba.aw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class ou2 implements xz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ou2() {
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

    @Override // com.baidu.tieba.xz3
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ku2.n().a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz3
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ku2.y0().c();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz3
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String i = ku2.h0().i(ku2.c());
            if (TextUtils.isEmpty(i)) {
                return xo3.r();
            }
            return i;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz3
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            db3 b0 = db3.b0();
            if (b0 == null) {
                return "";
            }
            return b0.W().j1().optString(TiebaStatic.Params.EQID, "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz3
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            db3 M = db3.M();
            if (M != null) {
                return M.b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz3
    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            db3 M = db3.M();
            if (M != null) {
                return M.O();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz3
    public String getScene() {
        InterceptResult invokeV;
        aw2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            db3 b0 = db3.b0();
            if (b0 != null && (W = b0.W()) != null) {
                return W.T();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz3
    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return or1.a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz3
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (qw2.T().getActivity() != null) {
                return mo3.e(qw2.T().getActivity());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.xz3
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return ((Integer) qw2.T().x().second).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.xz3
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return ((Integer) qw2.T().x().first).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.xz3
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return xo3.r();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz3
    public JSONObject n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            db3 b0 = db3.b0();
            JSONObject jSONObject = new JSONObject();
            if (b0 != null) {
                return b0.W().M();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz3
    public boolean b(Context context, Intent intent, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, intent, str, str2, str3)) == null) {
            if (ku2.a().d()) {
                return ku2.a().b(context, intent, str, str2, str3);
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xz3
    public boolean d(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull ez3 ez3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, jSONObject, swanAppDownloadType, ez3Var)) == null) {
            return ku2.d().d(context, jSONObject, swanAppDownloadType, ez3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xz3
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return ku2.q().a().getCookie(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xz3
    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return cn3.b(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xz3
    public boolean o(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view2)) == null) {
            if (qw2.T().getActivity() != null) {
                return mo3.q(qw2.T().getActivity(), view2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.xz3
    public Uri l(@NonNull Context context, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, context, file)) == null) {
            return ap3.a(context, file);
        }
        return (Uri) invokeLL.objValue;
    }
}
