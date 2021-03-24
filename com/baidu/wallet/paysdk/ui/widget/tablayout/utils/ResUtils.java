package com.baidu.wallet.paysdk.ui.widget.tablayout.utils;

import android.content.Context;
import com.baidu.apollon.utils.ChannelUtils;
import com.baidu.wallet.core.beans.BeanConstants;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public final class ResUtils {
    public static int[] getStyleableIntArray(Context context, String str) {
        Field[] fields;
        try {
            String packageName = context.getPackageName();
            if (ChannelUtils.isSpecailPackage()) {
                packageName = "com.baidu.wallet";
            }
            if (BeanConstants.CHANNEL_ID_IQIYI.equals(BeanConstants.CHANNEL_ID)) {
                packageName = "com.qiyi.plugin.wallet";
            }
            for (Field field : Class.forName(packageName + ".R$styleable").getFields()) {
                if (field.getName().equals(str)) {
                    return (int[]) field.get(null);
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static int styleable(Context context, String str, String str2) {
        Field[] fields;
        try {
            String packageName = context.getPackageName();
            if (ChannelUtils.isSpecailPackage()) {
                packageName = "com.baidu.wallet";
            }
            if (BeanConstants.CHANNEL_ID_IQIYI.equals(BeanConstants.CHANNEL_ID)) {
                packageName = "com.qiyi.plugin.wallet";
            }
            for (Field field : Class.forName(packageName + ".R$styleable").getFields()) {
                if (field.getName().equals(str + "_" + str2)) {
                    return ((Integer) field.get(null)).intValue();
                }
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
