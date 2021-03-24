package com.baidu.wallet.home.storage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.core.beans.BeanConstants;
/* loaded from: classes5.dex */
public final class a {
    public static void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_for_stamptime_with_id_" + HomeDataCacheManager.getInstance().getPpKey(context) + str, str2);
    }

    public static String a(Context context, String str) {
        return (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_for_stamptime_with_id_" + HomeDataCacheManager.getInstance().getPpKey(context) + str, "");
    }

    public static boolean a(Context context) {
        return ((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_for_home_mask_switch" + HomeDataCacheManager.getInstance().getPpKey(context), Boolean.FALSE)).booleanValue();
    }

    public static void a(Context context, boolean z) {
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_for_home_mask_switch" + HomeDataCacheManager.getInstance().getPpKey(context), Boolean.valueOf(z));
    }
}
