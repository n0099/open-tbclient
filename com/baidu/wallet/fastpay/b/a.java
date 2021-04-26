package com.baidu.wallet.fastpay.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.core.beans.BeanConstants;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class a {
    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || str.length() > 13) {
            return;
        }
        String str2 = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "history_new_1", "");
        String localDecrypt1 = !TextUtils.isEmpty(str2) ? SafePay.getInstance().localDecrypt1(str2) : "";
        if (TextUtils.isEmpty(localDecrypt1)) {
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "history_new_1", TextUtils.isEmpty(str) ? "" : SafePay.getInstance().localEncrypt1(str));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String[] split = localDecrypt1.split(",");
        int length = split.length;
        boolean z = length > 4;
        for (int i2 = 0; i2 < length; i2++) {
            if (split[i2] == null || split[i2].length() < 13 || str.substring(0, 13).equals(split[i2].substring(0, 13))) {
                z = false;
            } else {
                int i3 = length - 1;
                if (i2 < i3 || (i2 == i3 && !z)) {
                    sb.append(",");
                    sb.append(split[i2]);
                }
            }
        }
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "history_new_1", TextUtils.isEmpty(sb.toString()) ? "" : SafePay.getInstance().localEncrypt1(sb.toString()));
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "history_new_1", "");
    }

    public static ArrayList<String> a(Context context) {
        String[] split;
        if (context == null) {
            return null;
        }
        String str = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "history_new_1", "");
        String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SafePay.getInstance().localDecrypt1(str);
        if (TextUtils.isEmpty(localDecrypt1) || (split = localDecrypt1.split(",")) == null) {
            return null;
        }
        return new ArrayList<>(Arrays.asList(split));
    }
}
