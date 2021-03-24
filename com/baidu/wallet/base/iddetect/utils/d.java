package com.baidu.wallet.base.iddetect.utils;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.location.Address;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.webkit.sdk.WebKitFactory;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f23648a = {Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_REPORT_TYPE_JOININ_GROUP, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_WPA_STATE, Constants.VIA_REPORT_TYPE_QQFAVORITES, Constants.VIA_REPORT_TYPE_DATALINE, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "31", "32", "33", "34", "35", VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, PayConfig.PAYMENT_POS_KEY_MANGA, "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", WebKitFactory.OS_64, "65", "71", "81", "82", "91"};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f23649b = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f23650c = {"1", "0", "X", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, "8", "7", "6", "5", "4", "3", "2"};

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, String> f23651d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, Integer> f23652e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, Integer> f23653f = new HashMap();

    static {
        f23651d.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Address.Builder.BEI_JING);
        f23651d.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, Address.Builder.TIAN_JIN);
        f23651d.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, "河北");
        f23651d.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "山西");
        f23651d.put(Constants.VIA_REPORT_TYPE_WPA_STATE, "内蒙古");
        f23651d.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, "辽宁");
        f23651d.put(Constants.VIA_REPORT_TYPE_DATALINE, "吉林");
        f23651d.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "黑龙江");
        f23651d.put("31", Address.Builder.SHANG_HAI);
        f23651d.put("32", "江苏");
        f23651d.put("33", "浙江");
        f23651d.put("34", "安徽");
        f23651d.put("35", "福建");
        f23651d.put(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, "江西");
        f23651d.put(PayConfig.PAYMENT_POS_KEY_MANGA, "山东");
        f23651d.put("41", "河南");
        f23651d.put("42", "湖北");
        f23651d.put("43", "湖南");
        f23651d.put("44", "广东");
        f23651d.put("45", "广西");
        f23651d.put("46", "海南");
        f23651d.put("50", Address.Builder.CHONG_QIN);
        f23651d.put("51", "四川");
        f23651d.put("52", "贵州");
        f23651d.put("53", "云南");
        f23651d.put("54", "西藏");
        f23651d.put("61", "陕西");
        f23651d.put("62", "甘肃");
        f23651d.put("63", "青海");
        f23651d.put(WebKitFactory.OS_64, "宁夏");
        f23651d.put("65", "新疆");
        f23651d.put("71", "台湾");
        f23651d.put("81", "香港");
        f23651d.put("82", "澳门");
        f23651d.put("91", "国外");
        f23652e.put(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 10);
        f23652e.put("B", 11);
        f23652e.put("C", 12);
        f23652e.put("D", 13);
        f23652e.put(ExifInterface.LONGITUDE_EAST, 14);
        f23652e.put("F", 15);
        f23652e.put("G", 16);
        f23652e.put("H", 17);
        f23652e.put("J", 18);
        f23652e.put("K", 19);
        f23652e.put("L", 20);
        f23652e.put("M", 21);
        f23652e.put("N", 22);
        f23652e.put("P", 23);
        f23652e.put("Q", 24);
        f23652e.put("R", 25);
        f23652e.put(ExifInterface.LATITUDE_SOUTH, 26);
        f23652e.put(ExifInterface.GPS_DIRECTION_TRUE, 27);
        f23652e.put("U", 28);
        f23652e.put(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, 29);
        f23652e.put("X", 30);
        f23652e.put("Y", 31);
        f23652e.put(ExifInterface.LONGITUDE_WEST, 32);
        f23652e.put("Z", 33);
        f23652e.put("I", 34);
        f23652e.put("O", 35);
        f23653f.put(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 1);
        f23653f.put("B", 2);
        f23653f.put("C", 3);
        f23653f.put("R", 18);
        f23653f.put("U", 21);
        f23653f.put("Z", 26);
        f23653f.put("X", 24);
        f23653f.put(ExifInterface.LONGITUDE_WEST, 23);
        f23653f.put("O", 15);
        f23653f.put("N", 14);
    }

    public static boolean a(String str) {
        char[] charArray;
        if (str.length() == 18) {
            String substring = str.substring(0, 17);
            String substring2 = str.substring(17, 18);
            if (!b(substring) || (charArray = substring.toCharArray()) == null) {
                return false;
            }
            String a2 = a(a(a(charArray)));
            return a2.length() > 0 && a2.equalsIgnoreCase(substring2);
        }
        return false;
    }

    public static boolean b(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return c(str);
    }

    public static boolean c(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static int[] a(char[] cArr) {
        int length = cArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            try {
                iArr[i] = Integer.parseInt(String.valueOf(cArr[i]));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return iArr;
    }

    public static int a(int[] iArr) {
        if (f23649b.length == iArr.length) {
            int i = 0;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = 0;
                while (true) {
                    int[] iArr2 = f23649b;
                    if (i3 < iArr2.length) {
                        if (i2 == i3) {
                            i += iArr[i2] * iArr2[i3];
                        }
                        i3++;
                    }
                }
            }
            return i;
        }
        return 0;
    }

    public static String a(int i) {
        switch (i % 11) {
            case 0:
                return "1";
            case 1:
                return "0";
            case 2:
                return "x";
            case 3:
                return HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9;
            case 4:
                return "8";
            case 5:
                return "7";
            case 6:
                return "6";
            case 7:
                return "5";
            case 8:
                return "4";
            case 9:
                return "3";
            case 10:
                return "2";
            default:
                return "";
        }
    }
}
