package com.baidu.wallet.utils;

import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class StringUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f26633a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Pattern AcceptUrlPat = Pattern.compile("^(https?://|file:///android_asset/).*");

    /* renamed from: b  reason: collision with root package name */
    public static Pattern f26634b = Pattern.compile("(.*)<color=#?((?:\\d|[a-f]){3,8})>(\\d+)</color>(.*)", 2);

    /* renamed from: c  reason: collision with root package name */
    public static WeakReference<Paint> f26635c = new WeakReference<>(null);

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: char : 0x000b: AGET  (r1v2 char A[IMMUTABLE_TYPE, REMOVE]) = 
      (wrap: char[] : 0x0009: SGET  (r2v0 char[] A[IMMUTABLE_TYPE, REMOVE]) =  com.baidu.wallet.utils.StringUtil.a char[])
      (wrap: int : 0x0007: ARITH  (r1v1 int A[REMOVE]) = (wrap: int : 0x0005: ARITH  (r1v0 int A[REMOVE]) = (r3v0 byte) >> (4 byte)) & (15 int))
    ), (wrap: char : 0x0014: AGET  (r3v2 char A[IMMUTABLE_TYPE, REMOVE]) = 
      (wrap: char[] : 0x0012: SGET  (r1v3 char[] A[IMMUTABLE_TYPE, REMOVE]) =  com.baidu.wallet.utils.StringUtil.a char[])
      (wrap: int : 0x0010: ARITH  (r3v1 int A[REMOVE]) = (r3v0 byte) & (15 byte))
    )] */
    public static String a(byte b2) {
        StringBuilder sb = new StringBuilder();
        sb.append(f26633a[(b2 >> 4) & 15]);
        sb.append(f26633a[b2 & 15]);
        return sb.toString();
    }

    public static String arrayToString(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        i2 = (i2 < 0 || bArr.length < i2) ? 0 : 0;
        int i4 = i3 + i2;
        if (i4 > bArr.length) {
            i4 = bArr.length;
        }
        while (i2 < i4) {
            sb.append(a(bArr[i2]));
            i2++;
        }
        return sb.toString();
    }

    public static float getStringWidth(String str, float f2) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        Paint paint = f26635c.get();
        if (paint == null) {
            paint = new Paint();
            f26635c = new WeakReference<>(paint);
        }
        paint.setTextSize(f2);
        return paint.measureText(str);
    }

    public static CharSequence parseColorString(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        Matcher matcher = f26634b.matcher(charSequence);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (matcher.matches()) {
            spannableStringBuilder.append((CharSequence) matcher.group(1));
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(a(matcher.group(2)));
            String group = matcher.group(3);
            spannableStringBuilder.append((CharSequence) group);
            spannableStringBuilder.setSpan(foregroundColorSpan, spannableStringBuilder.length() - group.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) matcher.group(4));
        } else {
            spannableStringBuilder.append(charSequence);
        }
        return spannableStringBuilder;
    }

    public static String urlParam2JsonStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return com.baidu.android.common.others.lang.StringUtil.EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder(com.baidu.android.common.others.lang.StringUtil.ARRAY_START);
        for (String str2 : str.split("&")) {
            String[] split = str2.split("=");
            if (!TextUtils.isEmpty(split[0])) {
                sb.append(split[0]);
                sb.append(":\"");
                if (2 == split.length) {
                    sb.append(split[1]);
                }
                sb.append("\",");
            }
        }
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();
    }

    public static int a(String str) {
        int i2;
        int i3;
        int i4 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i5 = 255;
        String lowerCase = str.toLowerCase();
        try {
            String substring = lowerCase.substring(0, 2);
            String substring2 = lowerCase.substring(2, 4);
            String substring3 = lowerCase.substring(4, 6);
            String substring4 = lowerCase.substring(6, 8);
            i5 = Integer.valueOf(substring, 16).intValue();
            i2 = Integer.valueOf(substring2, 16).intValue();
            try {
                i3 = Integer.valueOf(substring3, 16).intValue();
                try {
                    i4 = Integer.valueOf(substring4, 16).intValue();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                i3 = 0;
                return Color.argb(i5, i2, i3, i4);
            }
        } catch (Exception unused3) {
            i2 = 0;
        }
        return Color.argb(i5, i2, i3, i4);
    }
}
