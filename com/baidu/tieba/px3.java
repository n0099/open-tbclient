package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class px3 extends sc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String v;

    public px3() {
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

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -2136141294:
                    if (str.equals("notifyInstall")) {
                        c = '\r';
                        break;
                    }
                    break;
                case -1996849701:
                    if (str.equals("installHijack")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1903789791:
                    if (str.equals("continueClick")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1768725569:
                    if (str.equals("notifyClick")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1263222921:
                    if (str.equals("openApp")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1165168761:
                    if (str.equals("notifyList")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1164961306:
                    if (str.equals("notifyShow")) {
                        c = 11;
                        break;
                    }
                    break;
                case -625158317:
                    if (str.equals("deleteDownload")) {
                        c = 3;
                        break;
                    }
                    break;
                case -606050596:
                    if (str.equals("resumeAllDownload")) {
                        c = 6;
                        break;
                    }
                    break;
                case -567202649:
                    if (str.equals("continue")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -451216226:
                    if (str.equals("pauseDownload")) {
                        c = 1;
                        break;
                    }
                    break;
                case -263045656:
                    if (str.equals("installSuccess")) {
                        c = 15;
                        break;
                    }
                    break;
                case 66344735:
                    if (str.equals("authorizeClick")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 184711125:
                    if (str.equals(com.baidu.mobads.sdk.internal.ap.d)) {
                        c = 2;
                        break;
                    }
                    break;
                case 388113743:
                    if (str.equals("overTwoDays")) {
                        c = 16;
                        break;
                    }
                    break;
                case 900412038:
                    if (str.equals("installApp")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1475610601:
                    if (str.equals("authorize")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1554935562:
                    if (str.equals("startDownload")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return "start";
                case 1:
                    return DownloadStatisticConstants.UBC_TYPE_PAUSE;
                case 2:
                    return DownloadStatisticConstants.UBC_TYPE_RESUME;
                case 3:
                    return "cancel";
                case 4:
                    return "install";
                case 5:
                    return "open";
                case 6:
                    return "continue";
                case 7:
                    return "authorize";
                case '\b':
                    return "guide";
                case '\t':
                    return "authorizeclick";
                case '\n':
                    return "guideclick";
                case 11:
                    return "notifyshow";
                case '\f':
                    return "notifyclick";
                case '\r':
                    return "notifyinstall";
                case 14:
                    return "notifylist";
                case 15:
                    return "installsuccess";
                case 16:
                    return "overtwodays";
                case 17:
                    return "installhijack";
                default:
                    return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sc3, com.baidu.tieba.rc3
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.k = ue3.e(TextUtils.equals(this.a, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME) ? 1 : 0);
            this.n = SwanAppNetworkUtils.f().type;
            if (this.h == null) {
                this.h = new JSONObject();
            }
            try {
                this.h.put("host", wo2.n().a());
                this.h.put("package", this.v);
            } catch (JSONException e) {
                if (rc3.j) {
                    e.printStackTrace();
                }
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }

    public void m(ox3 ox3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ox3Var) != null) || ox3Var == null) {
            return;
        }
        if (rc3.j) {
            Log.d("SwanAppUBCEvent", "setCommonData: " + ox3Var.a());
        }
        this.a = ox3Var.a;
        this.f = ox3Var.c;
        this.c = ox3Var.b;
        this.o = ox3Var.f;
        this.p = ox3Var.g;
        this.s = ox3Var.h;
        this.u = ox3Var.i;
        this.l = ox3Var.d;
        this.m = ox3Var.e;
    }
}
