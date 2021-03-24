package com.baidu.wallet.paysdk.storage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import java.util.Map;
/* loaded from: classes5.dex */
public final class PayPreferenceManager {
    public static final String PWDPAY_DISPLAY_SCORE_TIP = "pwdpay_display_score_tip";

    /* renamed from: a  reason: collision with root package name */
    public static final String f25853a = "_pay.preferences";

    /* renamed from: b  reason: collision with root package name */
    public static final String f25854b = "wallet_interface.preferences";

    public static boolean getBoolean(Context context, String str, boolean z) {
        return ((Boolean) SharedPreferencesUtils.getParam(context, "_pay.preferences", str, Boolean.valueOf(z))).booleanValue();
    }

    public static String getNewPpKey(Context context) {
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

    public static String getPpCheckTime(Context context) {
        String newPpKey = getNewPpKey(context);
        if (TextUtils.isEmpty(newPpKey)) {
            newPpKey = getPpKey(context);
        }
        if (TextUtils.isEmpty(newPpKey)) {
            return "";
        }
        return (String) SharedPreferencesUtils.getParam(context, "_pay.preferences", newPpKey + "time", "");
    }

    @Deprecated
    public static String getPpKey(Context context) {
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

    public static boolean getPpSwitch(Context context) {
        return false;
    }

    public static String getWalletInterfaceData(Context context, String str, String str2) {
        return (String) SharedPreferencesUtils.getParam(context, f25854b, str, str2);
    }

    public static void setBoolean(Context context, String str, boolean z) {
        SharedPreferencesUtils.setParam(context, "_pay.preferences", str, Boolean.valueOf(z));
    }

    public static void setPpCheckTime(Context context, String str) {
        String newPpKey = getNewPpKey(context);
        if (TextUtils.isEmpty(newPpKey)) {
            return;
        }
        SharedPreferencesUtils.setParam(context, "_pay.preferences", newPpKey + "time", str);
    }

    public static void setPpSwitch(Context context, boolean z) {
        String newPpKey = getNewPpKey(context);
        if (TextUtils.isEmpty(newPpKey)) {
            return;
        }
        SharedPreferencesUtils.setParam(context, "_pay.preferences", newPpKey, Boolean.valueOf(z));
    }

    public static void setWalletInterfaceData(Context context, String str, String str2) {
        SharedPreferencesUtils.setParam(context, f25854b, str, str2);
    }
}
