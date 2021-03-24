package com.baidu.wallet.personal.storage;

import android.content.Context;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.core.beans.BeanConstants;
/* loaded from: classes5.dex */
public final class PersonalPreferenceManager {
    public static boolean isPersonalBannerFirst(Context context) {
        return ((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_personal_banner_first_", Boolean.TRUE)).booleanValue();
    }

    public static void setPersonalBannerFirst(Context context, boolean z) {
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_personal_banner_first_", Boolean.valueOf(z));
    }
}
