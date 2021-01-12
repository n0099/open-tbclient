package com.baidubce.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class DateUtils {
    private static String DATA_TIME_Rfc822_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";
    private static String DATA_TIME_AlternateIso8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static Date parseRfc822Date(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATA_TIME_Rfc822_FORMAT, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        new Date();
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date parseAlternateIso8601Date(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATA_TIME_AlternateIso8601_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.parse(str);
    }

    public static String rfc822DateFormat() {
        return rfc822DateFormat(new Date());
    }

    public static String rfc822DateFormat(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATA_TIME_Rfc822_FORMAT, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String alternateIso8601DateFormat(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATA_TIME_AlternateIso8601_FORMAT, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(Long.valueOf(date.getTime()));
    }
}
