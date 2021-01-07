package com.bytedance.sdk.openadsdk.d.b.a.a;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeZone f7170a = TimeZone.getTimeZone("UTC");

    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x022f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date a(String str, ParsePosition parsePosition) throws ParseException {
        RuntimeException runtimeException;
        String message;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int length;
        TimeZone timeZone;
        char charAt;
        try {
            int index = parsePosition.getIndex();
            int i6 = index + 4;
            int a2 = a(str, index, i6);
            int i7 = a(str, i6, '-') ? i6 + 1 : i6;
            int i8 = i7 + 2;
            int a3 = a(str, i7, i8);
            int i9 = a(str, i8, '-') ? i8 + 1 : i8;
            int i10 = i9 + 2;
            int a4 = a(str, i9, i10);
            boolean a5 = a(str, i10, 'T');
            if (!a5 && str.length() <= i10) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(a2, a3 - 1, a4);
                parsePosition.setIndex(i10);
                return gregorianCalendar.getTime();
            }
            if (a5) {
                int i11 = i10 + 1;
                int i12 = i11 + 2;
                i4 = a(str, i11, i12);
                int i13 = a(str, i12, ':') ? i12 + 1 : i12;
                int i14 = i13 + 2;
                i3 = a(str, i13, i14);
                if (a(str, i14, ':')) {
                    i14++;
                }
                if (str.length() <= i14 || (charAt = str.charAt(i14)) == 'Z' || charAt == '+' || charAt == '-') {
                    i = 0;
                    i2 = 0;
                    i5 = i14;
                } else {
                    i5 = i14 + 2;
                    int a6 = a(str, i14, i5);
                    if (a6 > 59 && a6 < 63) {
                        a6 = 59;
                    }
                    if (a(str, i5, '.')) {
                        int i15 = i5 + 1;
                        i5 = a(str, i15 + 1);
                        int min = Math.min(i5, i15 + 3);
                        int a7 = a(str, i15, min);
                        switch (min - i15) {
                            case 1:
                                a7 *= 100;
                                break;
                            case 2:
                                a7 *= 10;
                                break;
                        }
                        i = a7;
                        i2 = a6;
                    } else {
                        i = 0;
                        i2 = a6;
                    }
                }
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = i10;
            }
            if (str.length() <= i5) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char charAt2 = str.charAt(i5);
            if (charAt2 == 'Z') {
                timeZone = f7170a;
                length = i5 + 1;
            } else if (charAt2 == '+' || charAt2 == '-') {
                String substring = str.substring(i5);
                if (substring.length() < 5) {
                    substring = substring + "00";
                }
                length = substring.length() + i5;
                if ("+0000".equals(substring) || "+00:00".equals(substring)) {
                    timeZone = f7170a;
                } else {
                    String str2 = "GMT" + substring;
                    timeZone = TimeZone.getTimeZone(str2);
                    String id = timeZone.getID();
                    if (!id.equals(str2) && !id.replace(":", "").equals(str2)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str2 + " given, resolves to " + timeZone.getID());
                    }
                }
            } else {
                throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(1, a2);
            gregorianCalendar2.set(2, a3 - 1);
            gregorianCalendar2.set(5, a4);
            gregorianCalendar2.set(11, i4);
            gregorianCalendar2.set(12, i3);
            gregorianCalendar2.set(13, i2);
            gregorianCalendar2.set(14, i);
            parsePosition.setIndex(length);
            return gregorianCalendar2.getTime();
        } catch (IndexOutOfBoundsException e) {
            runtimeException = e;
            String str3 = str == null ? null : '\"' + str + '\"';
            message = runtimeException.getMessage();
            if (message != null || message.isEmpty()) {
                message = "(" + runtimeException.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str3 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(runtimeException);
            throw parseException;
        } catch (NumberFormatException e2) {
            runtimeException = e2;
            if (str == null) {
            }
            message = runtimeException.getMessage();
            if (message != null) {
            }
            message = "(" + runtimeException.getClass().getName() + ")";
            ParseException parseException2 = new ParseException("Failed to parse date [" + str3 + "]: " + message, parsePosition.getIndex());
            parseException2.initCause(runtimeException);
            throw parseException2;
        } catch (IllegalArgumentException e3) {
            runtimeException = e3;
            if (str == null) {
            }
            message = runtimeException.getMessage();
            if (message != null) {
            }
            message = "(" + runtimeException.getClass().getName() + ")";
            ParseException parseException22 = new ParseException("Failed to parse date [" + str3 + "]: " + message, parsePosition.getIndex());
            parseException22.initCause(runtimeException);
            throw parseException22;
        }
    }

    private static boolean a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int a(String str, int i, int i2) throws NumberFormatException {
        int i3;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        int i4 = 0;
        if (i < i2) {
            i3 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = -digit;
        } else {
            i3 = i;
        }
        while (i3 < i2) {
            int i5 = i3 + 1;
            int digit2 = Character.digit(str.charAt(i3), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = (i4 * 10) - digit2;
            i3 = i5;
        }
        return -i4;
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                i++;
            } else {
                return i;
            }
        }
        return str.length();
    }
}
