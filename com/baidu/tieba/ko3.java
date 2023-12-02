package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ko3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static SwanAppLoginAndGetMobileDialog a(String str, boolean z, QuickLoginInfo quickLoginInfo, String str2, String str3) {
        InterceptResult invokeCommon;
        SwanAppLoginAndGetMobileDialog swanAppPhoneLoginDialog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Boolean.valueOf(z), quickLoginInfo, str2, str3})) == null) {
            Bundle bundle = new Bundle();
            if (quickLoginInfo != null && quickLoginInfo.supportQuickLogin) {
                swanAppPhoneLoginDialog = new SwanAppQuickLoginDialog();
            } else {
                swanAppPhoneLoginDialog = new SwanAppPhoneLoginDialog();
            }
            bundle.putString("auth_tip", str);
            bundle.putBoolean("is_night", z);
            bundle.putParcelable("quick_login_info", quickLoginInfo);
            bundle.putString("app_id", str3);
            bundle.putString("launch_from", str2);
            swanAppPhoneLoginDialog.setArguments(bundle);
            return swanAppPhoneLoginDialog;
        }
        return (SwanAppLoginAndGetMobileDialog) invokeCommon.objValue;
    }
}
