package com.baidu.zeus;

import android.text.format.Time;
import com.baidu.location.LocationClientOption;
import com.baidu.zeus.bouncycastle.DERTags;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class HttpDateTime {
    private static final String HTTP_DATE_RFC_REGEXP = "([0-9]{1,2})[- ]([A-Za-z]{3,3})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])";
    private static final Pattern HTTP_DATE_RFC_PATTERN = Pattern.compile(HTTP_DATE_RFC_REGEXP);
    private static final String HTTP_DATE_ANSIC_REGEXP = "[ ]([A-Za-z]{3,3})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})";
    private static final Pattern HTTP_DATE_ANSIC_PATTERN = Pattern.compile(HTTP_DATE_ANSIC_REGEXP);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class TimeOfDay {
        int hour;
        int minute;
        int second;

        TimeOfDay(int i, int i2, int i3) {
            this.hour = i;
            this.minute = i2;
            this.second = i3;
        }
    }

    public static Long parse(String str) {
        int month;
        int year;
        TimeOfDay timeOfDay;
        int i;
        int i2 = 1;
        Matcher matcher = HTTP_DATE_RFC_PATTERN.matcher(str);
        if (matcher.find()) {
            int date = getDate(matcher.group(1));
            month = getMonth(matcher.group(2));
            year = getYear(matcher.group(3));
            timeOfDay = getTime(matcher.group(4));
            i = date;
        } else {
            Matcher matcher2 = HTTP_DATE_ANSIC_PATTERN.matcher(str);
            if (matcher2.find()) {
                month = getMonth(matcher2.group(1));
                int date2 = getDate(matcher2.group(2));
                TimeOfDay time = getTime(matcher2.group(3));
                year = getYear(matcher2.group(4));
                timeOfDay = time;
                i = date2;
            } else {
                throw new IllegalArgumentException();
            }
        }
        if (year >= 2038) {
            year = 2038;
            month = 0;
        } else {
            i2 = i;
        }
        Time time2 = new Time("UTC");
        time2.set(timeOfDay.second, timeOfDay.minute, timeOfDay.hour, i2, month, year);
        return Long.valueOf(time2.toMillis(false));
    }

    private static int getDate(String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    private static int getMonth(String str) {
        switch (((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291) {
            case 9:
                return 11;
            case 10:
                return 1;
            case DERTags.IA5_STRING /* 22 */:
                return 0;
            case DERTags.VISIBLE_STRING /* 26 */:
                return 7;
            case 29:
                return 2;
            case 32:
                return 3;
            case 35:
                return 9;
            case 36:
                return 4;
            case 37:
                return 8;
            case 40:
                return 6;
            case 42:
                return 5;
            case 48:
                return 10;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static int getYear(String str) {
        if (str.length() == 2) {
            int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            if (charAt >= 70) {
                return charAt + 1900;
            }
            return charAt + 2000;
        } else if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + 1900;
        } else {
            if (str.length() == 4) {
                return ((str.charAt(0) - '0') * LocationClientOption.MIN_SCAN_SPAN) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
            }
            return 1970;
        }
    }

    private static TimeOfDay getTime(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int charAt = str.charAt(0) - '0';
        if (str.charAt(1) != ':') {
            i = 2;
            charAt = (charAt * 10) + (str.charAt(1) - '0');
        } else {
            i = 1;
        }
        int i5 = i + 1 + 1;
        int i6 = i5 + 1 + 1 + 1 + 1;
        return new TimeOfDay(charAt, ((str.charAt(i2) - '0') * 10) + (str.charAt(i5) - '0'), ((str.charAt(i3) - '0') * 10) + (str.charAt(i4) - '0'));
    }
}
