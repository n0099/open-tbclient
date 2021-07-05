package com.baidu.wallet.paysdk.storage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import java.util.Map;
/* loaded from: classes6.dex */
public final class PayPreferenceManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PWDPAY_DISPLAY_SCORE_TIP = "pwdpay_display_score_tip";

    /* renamed from: a  reason: collision with root package name */
    public static final String f26226a = "_pay.preferences";

    /* renamed from: b  reason: collision with root package name */
    public static final String f26227b = "wallet_interface.preferences";
    public transient /* synthetic */ FieldHolder $fh;

    public PayPreferenceManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, context, str, z)) == null) ? ((Boolean) SharedPreferencesUtils.getParam(context, "_pay.preferences", str, Boolean.valueOf(z))).booleanValue() : invokeLLZ.booleanValue;
    }

    public static String getNewPpKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Map<String, String> loginData = WalletLoginHelper.getInstance().getLoginData();
            if (loginData == null) {
                return null;
            }
            String str = loginData.get("pass_union_id");
            if (!TextUtils.isEmpty(str)) {
                return Md5Utils.toMD5(str);
            }
            String str2 = loginData.get("pass_user_name");
            if (!TextUtils.isEmpty(str2)) {
                return Md5Utils.toMD5(str2);
            }
            String str3 = loginData.get("pass_open_bduss");
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            return Md5Utils.toMD5(str3);
        }
        return (String) invokeL.objValue;
    }

    public static String getPpCheckTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String newPpKey = getNewPpKey(context);
            if (TextUtils.isEmpty(newPpKey)) {
                newPpKey = getPpKey(context);
            }
            if (TextUtils.isEmpty(newPpKey)) {
                return "";
            }
            return (String) SharedPreferencesUtils.getParam(context, "_pay.preferences", newPpKey + "time", "");
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String getPpKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            Map<String, String> loginData = WalletLoginHelper.getInstance().getLoginData();
            if (loginData == null) {
                return null;
            }
            String str = loginData.get("pass_uid");
            if (!TextUtils.isEmpty(str)) {
                return Md5Utils.toMD5(str);
            }
            String str2 = loginData.get("pass_bduss");
            if (!TextUtils.isEmpty(str2)) {
                return Md5Utils.toMD5(str2);
            }
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return Md5Utils.toMD5(str2);
        }
        return (String) invokeL.objValue;
    }

    public static boolean getPpSwitch(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String getWalletInterfaceData(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2)) == null) ? (String) SharedPreferencesUtils.getParam(context, f26227b, str, str2) : (String) invokeLLL.objValue;
    }

    public static void setBoolean(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65543, null, context, str, z) == null) {
            SharedPreferencesUtils.setParam(context, "_pay.preferences", str, Boolean.valueOf(z));
        }
    }

    public static void setPpCheckTime(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) {
            String newPpKey = getNewPpKey(context);
            if (TextUtils.isEmpty(newPpKey)) {
                return;
            }
            SharedPreferencesUtils.setParam(context, "_pay.preferences", newPpKey + "time", str);
        }
    }

    public static void setPpSwitch(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, context, z) == null) {
            String newPpKey = getNewPpKey(context);
            if (TextUtils.isEmpty(newPpKey)) {
                return;
            }
            SharedPreferencesUtils.setParam(context, "_pay.preferences", newPpKey, Boolean.valueOf(z));
        }
    }

    public static void setWalletInterfaceData(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, context, str, str2) == null) {
            SharedPreferencesUtils.setParam(context, f26227b, str, str2);
        }
    }
}
