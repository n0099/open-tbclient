package com.baidu.wallet.core.utils;

import android.text.TextUtils;
import com.google.zxing.client.result.ResultParser;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class StringUtils {
    public static CharSequence a(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && charSequence.toString().contains("*")) {
            int indexOf = charSequence.toString().indexOf("*");
            StringBuffer stringBuffer = new StringBuffer(charSequence);
            stringBuffer.insert(charSequence.toString().lastIndexOf("*") + 1, ' ');
            stringBuffer.insert(indexOf, ' ');
            return stringBuffer.toString();
        }
        return charSequence;
    }

    public static String fen2Yuan(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return new BigDecimal(str).divide(BigDecimal.valueOf(100L)).setScale(2).toString();
    }

    public static BigDecimal fen2YuanBigDecimal(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return new BigDecimal(str).divide(BigDecimal.valueOf(100L)).setScale(2);
    }

    public static String formatAmount(String str) {
        return fen2Yuan(yuan2Fen(str));
    }

    public static String formatMoneyAmount(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0.00";
        }
        if (str.contains(".")) {
            int indexOf = str.indexOf(".");
            String substring = str.substring(indexOf + 1);
            String substring2 = str.substring(0, indexOf);
            if (substring.length() < 2) {
                substring = substring + "0";
            }
            return substring2 + "." + substring;
        }
        return str + ".00";
    }

    public static String formatPhoneNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                stringBuffer.append(charAt);
            }
        }
        if (stringBuffer.length() > 11) {
            stringBuffer = new StringBuffer(stringBuffer.substring(stringBuffer.length() - 11));
        } else if (stringBuffer.length() < 11) {
            return null;
        }
        stringBuffer.insert(7, ' ');
        stringBuffer.insert(3, ' ');
        return stringBuffer.toString();
    }

    public static boolean isAmountMoreThanZero(String str) {
        BigDecimal bigDecimal;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            bigDecimal = new BigDecimal(str);
        } catch (Exception unused) {
            bigDecimal = new BigDecimal("0");
        }
        return bigDecimal.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean isBankCardNumber(String str) {
        return Pattern.compile("^[1-9][0-9]{5,31}$").matcher(str).matches();
    }

    public static boolean isEmail(String str) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches();
    }

    public static boolean isPhoneNumber(String str) {
        return Pattern.compile("^1[0-9]{10}$").matcher(str).matches();
    }

    public static CharSequence maskingPhoneNumber(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        if (!charSequence.toString().contains("*") && isPhoneNumber(charSequence.toString())) {
            charSequence = ((Object) charSequence.subSequence(0, 3)) + "*****" + ((Object) charSequence.subSequence(8, 11));
        }
        return a(charSequence);
    }

    public static BigDecimal parseBigDeceimal(String str) {
        try {
            return new BigDecimal(str);
        } catch (Exception unused) {
            return BigDecimal.ZERO;
        }
    }

    public static float parseFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String priceAdd(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return new BigDecimal(str).add(new BigDecimal(str2)).toString();
    }

    public static String replaceBom(String str) {
        return (TextUtils.isEmpty(str) || !str.startsWith(ResultParser.BYTE_ORDER_MARK)) ? str : str.substring(1);
    }

    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }
        return (String[]) collection.toArray(new String[collection.size()]);
    }

    public static String trimAll(String str) {
        return !TextUtils.isEmpty(str) ? str.replace(" ", "") : "";
    }

    public static String yuan2Fen(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return String.valueOf(new BigDecimal(str).multiply(new BigDecimal("100")).setScale(0));
        } catch (Exception unused) {
            return "0";
        }
    }

    public static BigDecimal yuan2FenBigDeceimal(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return new BigDecimal(str).multiply(new BigDecimal("100")).setScale(0);
        } catch (Exception unused) {
            return BigDecimal.ZERO;
        }
    }
}
