package com.baidu.tieba.util;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.Character;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class bs {
    private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static SimpleDateFormat b = new SimpleDateFormat("yyyy年");
    private static SimpleDateFormat c = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat d = new SimpleDateFormat("M月d日");
    private static SimpleDateFormat e = new SimpleDateFormat("M月d日 HH:mm");
    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd E");
    private static SimpleDateFormat h = new SimpleDateFormat("yy-M-d");
    private static SimpleDateFormat i = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static SimpleDateFormat j = new SimpleDateFormat("yyyy-MM-dd");
    private static long k = 86400000;
    private static long l = 3600000;
    private static long m = 60000;
    private static long n = 1000;
    private static String o = TiebaApplication.g().b().getString(R.string.time_hour_before);
    private static String p = TiebaApplication.g().b().getString(R.string.time_min_before);
    private static String q = TiebaApplication.g().b().getString(R.string.time_sec_before);
    private static Date r = new Date();
    private static final Pattern s = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private static final char[] t;
    private static final char[] u;
    private static byte[] v;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        if (timeZone != null) {
            a.setTimeZone(timeZone);
            b.setTimeZone(timeZone);
            c.setTimeZone(timeZone);
            d.setTimeZone(timeZone);
            e.setTimeZone(timeZone);
            f.setTimeZone(timeZone);
            g.setTimeZone(timeZone);
            h.setTimeZone(timeZone);
            i.setTimeZone(timeZone);
            j.setTimeZone(timeZone);
        }
        t = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        u = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
        v = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
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
        synchronized (f) {
            format = f.format(date);
        }
        return format;
    }

    public static String a() {
        String format;
        Date date = new Date();
        synchronized (i) {
            format = i.format(date);
        }
        return format;
    }

    public static String a(int i2, int i3, int i4) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i2);
        calendar.set(2, i3);
        calendar.set(5, i4);
        switch (calendar.get(7)) {
            case 1:
                return String.valueOf("周") + "日";
            case 2:
                return String.valueOf("周") + "一";
            case 3:
                return String.valueOf("周") + "二";
            case 4:
                return String.valueOf("周") + "三";
            case 5:
                return String.valueOf("周") + "四";
            case 6:
                return String.valueOf("周") + "五";
            case 7:
                return String.valueOf("周") + "六";
            default:
                return "周";
        }
    }

    public static String d(Date date) {
        if (date == null) {
            return "";
        }
        Date date2 = new Date();
        if (date == null) {
            return "";
        }
        int day = date2.getDay() - date.getDay();
        long time = date2.getTime() - date.getTime();
        return time < 0 ? time > -120000 ? "刚刚" : c(date) : time < 30000 ? "刚刚" : time < 60000 ? "半分钟前" : time < 3600000 ? String.valueOf(String.valueOf((time * 60) / 3600000)) + "分钟前" : time < 86400000 ? day == 0 ? b(date) : "1天前" : time < 2678400000L ? String.valueOf(String.valueOf((time * 31) / 2678400000L)) + "天前" : time < 2764800000L ? "1个月前" : c(date);
    }

    public static String e(Date date) {
        return a(new Date(), date);
    }

    private static String a(Date date, Date date2) {
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
            return c(date2);
        } else if (time < 30000) {
            return "刚刚";
        } else {
            if (time < 60000) {
                return "半分钟前";
            }
            if (time < 3600000) {
                return String.valueOf(String.valueOf((time * 60) / 3600000)) + "分钟前";
            }
            if (time < 86400000) {
                if (day == 0) {
                    return b(date2);
                }
                return "1天前";
            } else if (time < 2678400000L) {
                return String.valueOf(String.valueOf((time * 31) / 2678400000L)) + "天前";
            } else {
                if (time < 2764800000L) {
                    return "1个月前";
                }
                if (date.getYear() == date2.getYear()) {
                    synchronized (j) {
                        format2 = j.format(date2);
                    }
                    return format2;
                }
                synchronized (f) {
                    format = f.format(date2);
                }
                return format;
            }
        }
    }

    public static String a(InputStream inputStream) {
        String str = null;
        if (inputStream != null) {
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
                byte[] digest = messageDigest.digest();
                if (digest != null) {
                    StringBuilder sb = new StringBuilder(digest.length * 2);
                    for (int i2 = 0; i2 < digest.length; i2++) {
                        sb.append(t[(digest[i2] & 240) >>> 4]);
                        sb.append(t[digest[i2] & 15]);
                    }
                    str = sb.toString();
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.e.a("StringHelper", "ToMd5", e2.toString());
            } finally {
                r.a(inputStream);
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
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(String str, int i2) {
        int i3;
        if (str == null) {
            return String.valueOf("");
        }
        int length = str.length();
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            Character.UnicodeBlock of = Character.UnicodeBlock.of(str.charAt(i4));
            if (of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                i3 = i5 + 2;
            } else {
                i3 = i5 + 1;
            }
            if (i3 >= 12) {
                break;
            }
            i4++;
            i5 = i3;
        }
        if (i4 < length) {
            return String.valueOf(str.substring(0, i4 + 1)) + "...";
        }
        return str;
    }

    public static String a(byte[] bArr) {
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
                sb.append(u[i4 >>> 2]);
                sb.append(u[(i4 & 3) << 4]);
                sb.append("==");
                break;
            }
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 == length) {
                sb.append(u[i4 >>> 2]);
                sb.append(u[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                sb.append(u[(i6 & 15) << 2]);
                sb.append("=");
                break;
            }
            i2 = i5 + 1;
            int i7 = bArr[i5] & 255;
            sb.append(u[i4 >>> 2]);
            sb.append(u[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
            sb.append(u[((i6 & 15) << 2) | ((i7 & 192) >>> 6)]);
            sb.append(u[i7 & 63]);
        }
        return sb.toString();
    }

    public static String f(String str) {
        return a(str);
    }

    public static String g(String str) {
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
                com.baidu.adp.lib.util.e.a("StringHelper", "getHighLightString", exc.toString());
                return str2;
            }
        } catch (Exception e3) {
            str2 = null;
            exc = e3;
        }
    }

    public static String a(long j2) {
        String c2;
        synchronized (r) {
            r.setTime(j2);
            Date date = r;
            if (date == null) {
                c2 = "";
            } else {
                long time = new Date().getTime() - date.getTime();
                c2 = (time >= k || time <= 0) ? c(date) : time < l ? time < m ? String.valueOf(String.valueOf(time / n)) + q : String.valueOf(String.valueOf(time / m)) + p : String.valueOf(String.valueOf(time / l)) + o;
            }
        }
        return c2;
    }

    public static int h(String str) {
        int i2 = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = s.matcher(str);
            while (matcher.find()) {
                if (com.baidu.tieba.data.emotions.l.a().a(matcher.group())) {
                    i2++;
                }
            }
        }
        return i2;
    }
}
