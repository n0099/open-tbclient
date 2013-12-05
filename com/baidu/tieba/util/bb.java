package com.baidu.tieba.util;

import android.graphics.Color;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.Character;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f2596a = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static SimpleDateFormat b = new SimpleDateFormat("yyyy年");
    private static SimpleDateFormat c = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat d = new SimpleDateFormat("M月d日");
    private static SimpleDateFormat e = new SimpleDateFormat("M月d日 HH:mm");
    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat g = new SimpleDateFormat("yy-M-d");
    private static SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static SimpleDateFormat i = new SimpleDateFormat("yyyy-MM-dd");
    private static long j = Util.MILLSECONDS_OF_DAY;
    private static long k = Util.MILLSECONDS_OF_HOUR;
    private static long l = Util.MILLSECONDS_OF_MINUTE;
    private static long m = 1000;
    private static String n = TiebaApplication.h().getString(R.string.time_hour_before);
    private static String o = TiebaApplication.h().getString(R.string.time_min_before);
    private static String p = TiebaApplication.h().getString(R.string.time_sec_before);
    private static Date q = new Date();
    private static final Pattern r = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private static final char[] s;
    private static final char[] t;
    private static byte[] u;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        if (timeZone != null) {
            f2596a.setTimeZone(timeZone);
            b.setTimeZone(timeZone);
            c.setTimeZone(timeZone);
            d.setTimeZone(timeZone);
            e.setTimeZone(timeZone);
            f.setTimeZone(timeZone);
            g.setTimeZone(timeZone);
            h.setTimeZone(timeZone);
            i.setTimeZone(timeZone);
        }
        s = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        t = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        u = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public static String a(Date date) {
        String format;
        synchronized (e) {
            format = e.format(date);
        }
        return format;
    }

    public static String b(Date date) {
        String format;
        synchronized (c) {
            format = c.format(date);
        }
        return format;
    }

    public static String c(Date date) {
        String format;
        synchronized (d) {
            format = d.format(date);
        }
        return format;
    }

    public static String d(Date date) {
        String format;
        synchronized (f) {
            format = f.format(date);
        }
        return format;
    }

    public static String a(long j2) {
        String format;
        Date date = new Date(j2);
        synchronized (f2596a) {
            format = f2596a.format(date);
        }
        return format;
    }

    public static String a() {
        String format;
        Date date = new Date();
        synchronized (h) {
            format = h.format(date);
        }
        return format;
    }

    public static String e(Date date) {
        return date == null ? "" : a(new Date(), date);
    }

    public static String a(Date date, Date date2) {
        if (date2 == null) {
            return "";
        }
        int day = date.getDay() - date2.getDay();
        long time = date.getTime() - date2.getTime();
        if (time < 0) {
            if (time > -120000) {
                return "刚刚";
            }
            return d(date2);
        } else if (time >= 30000) {
            long j2 = 30000 * 2;
            if (time < j2) {
                return "半分钟前";
            }
            long j3 = j2 * 60;
            if (time < j3) {
                return String.valueOf((time * 60) / j3) + "分钟前";
            }
            long j4 = j3 * 24;
            if (time < j4) {
                if (day == 0) {
                    return b(date2);
                }
                return "1天前";
            }
            long j5 = j4 * 31;
            if (time < j5) {
                return String.valueOf((time * 31) / j5) + "天前";
            }
            if (time < j5 + Util.MILLSECONDS_OF_DAY) {
                return "1个月前";
            }
            return d(date2);
        } else {
            return "刚刚";
        }
    }

    public static String f(Date date) {
        return b(new Date(), date);
    }

    public static String b(Date date, Date date2) {
        String format;
        String format2;
        if (date2 == null) {
            return "";
        }
        int day = date.getDay() - date2.getDay();
        long time = date.getTime() - date2.getTime();
        if (time < 0) {
            if (time > -120000) {
                return "刚刚";
            }
            return d(date2);
        } else if (time >= 30000) {
            long j2 = 30000 * 2;
            if (time < j2) {
                return "半分钟前";
            }
            long j3 = j2 * 60;
            if (time < j3) {
                return String.valueOf((time * 60) / j3) + "分钟前";
            }
            long j4 = j3 * 24;
            if (time < j4) {
                if (day == 0) {
                    return b(date2);
                }
                return "1天前";
            }
            long j5 = j4 * 31;
            if (time < j5) {
                return String.valueOf((time * 31) / j5) + "天前";
            }
            if (time < j5 + Util.MILLSECONDS_OF_DAY) {
                return "1个月前";
            }
            if (date.getYear() == date2.getYear()) {
                synchronized (i) {
                    format2 = i.format(date2);
                }
                return format2;
            }
            synchronized (f) {
                format = f.format(date2);
            }
            return format;
        } else {
            return "刚刚";
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(s[(bArr[i2] & 240) >>> 4]);
            sb.append(s[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    public static String a(InputStream inputStream) {
        String str = null;
        if (inputStream != null) {
            try {
                try {
                    byte[] bArr = new byte[1024];
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str = a(messageDigest.digest());
                } catch (Exception e2) {
                    bd.a("StringHelper", "ToMd5", e2.toString());
                }
            } finally {
                o.a(inputStream);
            }
        }
        return str;
    }

    public static String a(String str) {
        try {
            return a(new ByteArrayInputStream(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            return null;
        }
    }

    public static boolean a(char c2) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c2);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean b(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0 || str.equals("null");
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, BdUtil.UTF8);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e(String str) {
        try {
            return URLDecoder.decode(str, BdUtil.UTF8);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(String str, int i2) {
        if (str == null || i2 <= 0) {
            return String.valueOf("");
        }
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (a(str.charAt(i3))) {
                i4 += 2;
            } else {
                i4++;
            }
            if (i4 >= i2) {
                break;
            }
            i3++;
        }
        if (i3 < length) {
            return str.substring(0, i3 + 1) + "...";
        }
        return str;
    }

    public static String b(byte[] bArr) {
        int length = bArr.length;
        int i2 = 0;
        StringBuilder sb = new StringBuilder(length / 2);
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i3 == length) {
                sb.append(t[i4 >>> 2]);
                sb.append(t[(i4 & 3) << 4]);
                sb.append("==");
                break;
            }
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 == length) {
                sb.append(t[i4 >>> 2]);
                sb.append(t[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                sb.append(t[(i6 & 15) << 2]);
                sb.append("=");
                break;
            }
            i2 = i5 + 1;
            int i7 = bArr[i5] & 255;
            sb.append(t[i4 >>> 2]);
            sb.append(t[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
            sb.append(t[((i6 & 15) << 2) | ((i7 & 192) >>> 6)]);
            sb.append(t[i7 & 63]);
        }
        return sb.toString();
    }

    public static String f(String str) {
        return a(str);
    }

    public static String a(String str, Color color) {
        String str2;
        Exception exc;
        if (str == null) {
            return "";
        }
        try {
            String replaceAll = str.replaceAll("<em>", "<font color='#007bd1'>");
            try {
                return replaceAll.replaceAll("</em>", "</font>");
            } catch (Exception e2) {
                str2 = replaceAll;
                exc = e2;
                bd.a("StringHelper", "getHighLightString", exc.toString());
                return str2;
            }
        } catch (Exception e3) {
            str2 = null;
            exc = e3;
        }
    }

    public static String b(long j2) {
        String g2;
        synchronized (q) {
            q.setTime(j2);
            g2 = g(q);
        }
        return g2;
    }

    private static String g(Date date) {
        if (date == null) {
            return "";
        }
        long time = new Date().getTime() - date.getTime();
        if (time < j && time > 0) {
            if (time < k) {
                if (time < l) {
                    return String.valueOf(time / m) + p;
                }
                return String.valueOf(time / l) + o;
            }
            return String.valueOf(time / k) + n;
        }
        return d(date);
    }

    public static int g(String str) {
        int i2 = 0;
        if (str != null && str.length() != 0) {
            w wVar = new w();
            Matcher matcher = r.matcher(str);
            while (matcher.find()) {
                if (wVar.b(matcher.group()) != 0) {
                    i2++;
                }
            }
        }
        return i2;
    }
}
