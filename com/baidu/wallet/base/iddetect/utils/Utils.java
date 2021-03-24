package com.baidu.wallet.base.iddetect.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class Utils {
    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String formatDate(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 8) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        sb.insert(4, "-");
        sb.insert(7, "-");
        return sb.toString();
    }

    public static String getMetaValue(Context context, String str) {
        Bundle bundle;
        if (context != null) {
            if (str != null) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    bundle = applicationInfo != null ? applicationInfo.metaData : null;
                    if (bundle == null) {
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    return null;
                }
            }
            return bundle.getString(str);
        }
        return null;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String getVersionCode(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean isCardNo(String str) {
        return true;
    }

    public static boolean isChinese(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^[一-龥]+$");
    }

    public static boolean isEmailInvalid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^([a-z0-9A-Z]+[-_|\\.]?)+@[a-z0-9A-Z]+(\\.[a-z0-9A-Z]+)+$");
    }

    public static boolean isNameInvalid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^[一-龥a-zA-Z]+$");
    }

    public static boolean isSpecialCharInName(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).find();
    }

    public static boolean isTelephoneNO(String str) {
        return !TextUtils.isEmpty(str) && str.matches("^[0-9]+$") && str.length() <= 10;
    }

    public static boolean isTuitionCodeInvaild(String str) {
        return !TextUtils.isEmpty(str) && str.matches("^[A-Za-z][0-9A-Za-z]{5}$");
    }

    public static void prepareMatrix(Matrix matrix, boolean z, int i, int i2, int i3) {
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate(i);
        float f2 = i2;
        float f3 = i3;
        matrix.postScale(f2 / 2000.0f, f3 / 2000.0f);
        matrix.postTranslate(f2 / 2.0f, f3 / 2.0f);
    }

    public static int px2dip(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int rank(int i, int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            int i2 = 0;
            if (iArr.length == 1) {
                return iArr[0] != i ? -1 : 0;
            }
            int length = iArr.length - 1;
            while (i2 <= length) {
                int i3 = ((length - i2) / 2) + i2;
                if (i < iArr[i3]) {
                    length = i3 - 1;
                } else if (i <= iArr[i3]) {
                    return i3;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        return -1;
    }
}
