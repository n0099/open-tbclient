package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar;

import com.xiaomi.mipush.sdk.Constants;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
/* loaded from: classes11.dex */
class b {
    private static final char[][] ovh = {"0.".toCharArray(), "0.0".toCharArray(), "0.00".toCharArray(), "0.000".toCharArray(), "0.0000".toCharArray(), "0.00000".toCharArray(), "0.000000".toCharArray(), "0.0000000".toCharArray(), "0.00000000".toCharArray(), "0.000000000".toCharArray(), "0.0000000000".toCharArray(), "0.00000000000".toCharArray(), "0.000000000000".toCharArray(), "0.0000000000000".toCharArray(), "0.00000000000000".toCharArray(), "0.000000000000000".toCharArray()};

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b(double d, int i) {
        char[] copyOf;
        int abs = Math.abs(i);
        double abs2 = (Math.abs(d) * Math.pow(10.0d, abs)) + 0.5d;
        if (abs2 > 9.99999999999999E14d || abs > 16) {
            return c(d, abs);
        }
        long nextUp = (long) Math.nextUp(abs2);
        if (nextUp < 1) {
            return "0";
        }
        char[] charArray = Long.toString(nextUp).toCharArray();
        if (charArray.length > abs) {
            int length = charArray.length - abs;
            int length2 = charArray.length - 1;
            while (length2 >= length && charArray[length2] == '0') {
                length2--;
            }
            if (length2 >= length) {
                copyOf = new char[length2 + 2];
                System.arraycopy(charArray, 0, copyOf, 0, length);
                copyOf[length] = '.';
                System.arraycopy(charArray, length, copyOf, length + 1, (length2 - length) + 1);
            } else {
                copyOf = new char[length];
                System.arraycopy(charArray, 0, copyOf, 0, length);
            }
        } else {
            int length3 = charArray.length - 1;
            while (length3 >= 0 && charArray[length3] == '0') {
                length3--;
            }
            char[] cArr = ovh[abs - charArray.length];
            copyOf = Arrays.copyOf(cArr, cArr.length + length3 + 1);
            System.arraycopy(charArray, 0, copyOf, cArr.length, length3 + 1);
        }
        return Math.signum(d) > 0.0d ? new String(copyOf) : Constants.ACCEPT_TIME_SEPARATOR_SERVER + new String(copyOf);
    }

    private static String c(double d, int i) {
        String bigDecimal = new BigDecimal(Double.toString(d)).setScale(Math.abs(i), RoundingMode.HALF_UP).toString();
        if (i != 0) {
            int length = bigDecimal.length() - 1;
            while (length >= 0 && bigDecimal.charAt(length) == '0') {
                length--;
            }
            String substring = bigDecimal.substring(0, length + 1);
            if (substring.charAt(substring.length() - 1) == '.') {
                return substring.substring(0, substring.length() - 1);
            }
            return substring;
        }
        return bigDecimal;
    }
}
