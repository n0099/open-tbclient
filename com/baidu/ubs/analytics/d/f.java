package com.baidu.ubs.analytics.d;

import com.baidu.webkit.internal.ETAG;
/* loaded from: classes8.dex */
public final class f {
    public static String encode(String str) {
        if (str != null && str.length() != 0) {
            char[] charArray = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : charArray) {
                String binaryString = Integer.toBinaryString(c);
                while (binaryString.length() < 8) {
                    binaryString = "0" + binaryString;
                }
                sb.append(binaryString);
            }
            while (sb.length() % 6 != 0) {
                sb.append("0");
            }
            String valueOf = String.valueOf(sb);
            char[] cArr = new char[valueOf.length() / 6];
            for (int i = 0; i < cArr.length; i++) {
                int parseInt = Integer.parseInt(valueOf.substring(0, 6), 2);
                valueOf = valueOf.substring(6);
                cArr[i] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(parseInt);
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(cArr));
            if (str.length() % 3 == 1) {
                sb2.append("==");
            } else if (str.length() % 3 == 2) {
                sb2.append(ETAG.EQUAL);
            }
            for (int i2 = 76; i2 < sb2.length(); i2 += 76) {
                sb2.insert(i2, "\r\n");
            }
            sb2.append("\r\n");
            return String.valueOf(sb2);
        }
        return str;
    }
}
