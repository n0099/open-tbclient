package com.baidu.tieba.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.Character;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class StringHelper {
    private static SimpleDateFormat FORMATE_DATE_ALL = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static SimpleDateFormat FORMATE_DATE_YEAR = new SimpleDateFormat("yyyy年");
    private static SimpleDateFormat FORMATE_DATE_TIME = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat FORMATE_DATE_MOUTH = new SimpleDateFormat("M月d日");
    private static SimpleDateFormat FORMATE_DATE_MOUTH_TIME = new SimpleDateFormat("M月d日 HH:mm");
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] base64EncodeChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] base64DecodeChars = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String getDateStringMdHm(Date date) {
        return FORMATE_DATE_MOUTH_TIME.format(date);
    }

    public static String getDateStringHm(Date date) {
        return FORMATE_DATE_TIME.format(date);
    }

    public static String getTimeString(long time) {
        Date date = new Date(time);
        return FORMATE_DATE_ALL.format(date);
    }

    public static String getCurrentString() {
        Date date = new Date();
        return FORMATE_DATE_ALL.format(date);
    }

    public static String GetTimeString(Date tObj) {
        if (tObj == null) {
            return "";
        }
        Date tClient = new Date();
        long tDiff = tClient.getTime() - tObj.getTime();
        if (tDiff < 60000) {
            return "1分钟前";
        }
        if (tDiff < 3600000) {
            return String.valueOf(String.valueOf((tDiff / 1000) / 60)) + "分钟前";
        }
        if (tClient.getYear() == tObj.getYear()) {
            if (tClient.getMonth() == tObj.getMonth() && tClient.getDate() == tObj.getDate()) {
                return FORMATE_DATE_TIME.format(tObj);
            }
            return FORMATE_DATE_MOUTH.format(tObj);
        }
        return FORMATE_DATE_YEAR.format(tObj);
    }

    public static String toHexString(byte[] b) {
        if (b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEX_DIGITS[(b[i] & 240) >>> 4]);
            sb.append(HEX_DIGITS[b[i] & 15]);
        }
        return sb.toString();
    }

    public static String ToMd5(InputStream in) {
        String ret = null;
        if (in == null) {
            return null;
        }
        try {
            byte[] buffer = new byte[1024];
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            while (true) {
                int numRead = in.read(buffer);
                if (numRead <= 0) {
                    break;
                }
                md5.update(buffer, 0, numRead);
            }
            in.close();
            ret = toHexString(md5.digest());
        } catch (Exception e) {
        }
        return ret;
    }

    public static String ToMd5(String str) {
        try {
            byte[] bMsg = str.getBytes("UTF-8");
            InputStream in = new ByteArrayInputStream(bMsg);
            String ret = ToMd5(in);
            return ret;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean ContentChinese(String str) {
        if (str == null || str.length() < 1) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (isChinese(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean isAccount(String account) {
        Pattern pattern = Pattern.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\w]+$");
        boolean tf = pattern.matcher(account).matches();
        if (tf) {
            int totalLen = 0;
            for (int i = 0; i < account.length(); i++) {
                String tempStr = String.valueOf(account.charAt(i));
                if (tempStr.getBytes().length == 1) {
                    totalLen++;
                } else {
                    totalLen += 2;
                }
            }
            return totalLen > 0 && totalLen <= 14;
        }
        return false;
    }

    public static boolean isPassword(String password) {
        int len = password.length();
        if (len < 6 || len > 14) {
            return false;
        }
        int byteLen = password.getBytes().length;
        return byteLen <= len;
    }

    public static boolean isForumName(String name) {
        return name != null && name.length() > 0;
    }

    public static boolean isMobileNo(String phone) {
        Pattern p = Pattern.compile("1\\d{10}");
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0 || s.equals("null");
    }

    public static String getUrlEncode(String s) {
        if (s == null) {
            return null;
        }
        try {
            String result = URLEncoder.encode(s, "utf-8");
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getUrlDecode(String s) {
        try {
            String result = URLDecoder.decode(s, "utf-8");
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int byteLength(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Integer.toHexString(string.charAt(i)).length() == 4) {
                count += 2;
            } else {
                count++;
            }
        }
        return count;
    }

    public static String cutString(String string, int length) {
        if (string == null || length <= 0) {
            return String.valueOf("");
        }
        int len = string.length();
        int count = 0;
        int i = 0;
        while (i < len) {
            char c = string.charAt(i);
            if (isChinese(c)) {
                count += 2;
            } else {
                count++;
            }
            if (count >= length) {
                break;
            }
            i++;
        }
        if (i < len) {
            return String.valueOf(string.substring(0, i + 1)) + "...";
        }
        return string;
    }

    public static String base64Encode(byte[] data) {
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;
        while (true) {
            if (i >= len) {
                break;
            }
            int i2 = i + 1;
            int b1 = data[i] & 255;
            if (i2 == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 3) << 4]);
                sb.append("==");
                break;
            }
            int i3 = i2 + 1;
            int b2 = data[i2] & 255;
            if (i3 == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 3) << 4) | ((b2 & 240) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 15) << 2]);
                sb.append("=");
                break;
            }
            int b3 = data[i3] & 255;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 3) << 4) | ((b2 & 240) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 15) << 2) | ((b3 & 192) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 63]);
            i = i3 + 1;
        }
        return sb.toString();
    }

    public static byte[] base64Decode(String str) {
        int i;
        int b1;
        int b2;
        int b3;
        int b4;
        byte[] data = str.getBytes();
        int len = data.length;
        ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
        int i2 = 0;
        while (i2 < len) {
            while (true) {
                i = i2 + 1;
                b1 = base64DecodeChars[data[i2]];
                if (i >= len || b1 != -1) {
                    break;
                }
                i2 = i;
            }
            if (b1 == -1) {
                break;
            }
            do {
                int i3 = i;
                i = i3 + 1;
                b2 = base64DecodeChars[data[i3]];
                if (i >= len) {
                    break;
                }
            } while (b2 == -1);
            if (b2 == -1) {
                break;
            }
            buf.write((b1 << 2) | ((b2 & 48) >>> 4));
            do {
                int i4 = i;
                i = i4 + 1;
                int b32 = data[i4];
                if (b32 == 61) {
                    return buf.toByteArray();
                }
                b3 = base64DecodeChars[b32];
                if (i >= len) {
                    break;
                }
            } while (b3 == -1);
            if (b3 == -1) {
                break;
            }
            buf.write(((b2 & 15) << 4) | ((b3 & 60) >>> 2));
            do {
                int i5 = i;
                i = i5 + 1;
                int b42 = data[i5];
                if (b42 == 61) {
                    return buf.toByteArray();
                }
                b4 = base64DecodeChars[b42];
                if (i >= len) {
                    break;
                }
            } while (b4 == -1);
            if (b4 == -1) {
                break;
            }
            buf.write(((b3 & 3) << 6) | b4);
            i2 = i;
        }
        return buf.toByteArray();
    }

    public static String getNameFromUrl(String url) {
        String name = null;
        try {
            int start = url.lastIndexOf("/");
            int end = url.lastIndexOf(".");
            if (start == -1) {
                name = url;
            } else if (start < end) {
                name = url.substring(start, end);
            } else {
                name = url.substring(start);
            }
        } catch (Exception ex) {
            TiebaLog.e("StringHelper", "getNameFromUrl", ex.getMessage());
        }
        return name;
    }
}
