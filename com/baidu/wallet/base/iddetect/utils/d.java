package com.baidu.wallet.base.iddetect.utils;

import androidx.room.RoomMasterTable;
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
    public static final String[] f24062a = {Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_REPORT_TYPE_JOININ_GROUP, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_WPA_STATE, Constants.VIA_REPORT_TYPE_QQFAVORITES, Constants.VIA_REPORT_TYPE_DATALINE, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "31", "32", "33", "34", "35", VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, PayConfig.PAYMENT_POS_KEY_MANGA, "41", RoomMasterTable.DEFAULT_ID, "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", WebKitFactory.OS_64, "65", "71", "81", "82", "91"};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f24063b = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f24064c = {"1", "0", "X", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, "8", "7", "6", "5", "4", "3", "2"};

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, String> f24065d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, Integer> f24066e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, Integer> f24067f = new HashMap();

    static {
        f24065d.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Address.Builder.BEI_JING);
        f24065d.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, Address.Builder.TIAN_JIN);
        f24065d.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, "河北");
        f24065d.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "山西");
        f24065d.put(Constants.VIA_REPORT_TYPE_WPA_STATE, "内蒙古");
        f24065d.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, "辽宁");
        f24065d.put(Constants.VIA_REPORT_TYPE_DATALINE, "吉林");
        f24065d.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "黑龙江");
        f24065d.put("31", Address.Builder.SHANG_HAI);
        f24065d.put("32", "江苏");
        f24065d.put("33", "浙江");
        f24065d.put("34", "安徽");
        f24065d.put("35", "福建");
        f24065d.put(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, "江西");
        f24065d.put(PayConfig.PAYMENT_POS_KEY_MANGA, "山东");
        f24065d.put("41", "河南");
        f24065d.put(RoomMasterTable.DEFAULT_ID, "湖北");
        f24065d.put("43", "湖南");
        f24065d.put("44", "广东");
        f24065d.put("45", "广西");
        f24065d.put("46", "海南");
        f24065d.put("50", Address.Builder.CHONG_QIN);
        f24065d.put("51", "四川");
        f24065d.put("52", "贵州");
        f24065d.put("53", "云南");
        f24065d.put("54", "西藏");
        f24065d.put("61", "陕西");
        f24065d.put("62", "甘肃");
        f24065d.put("63", "青海");
        f24065d.put(WebKitFactory.OS_64, "宁夏");
        f24065d.put("65", "新疆");
        f24065d.put("71", "台湾");
        f24065d.put("81", "香港");
        f24065d.put("82", "澳门");
        f24065d.put("91", "国外");
        f24066e.put("A", 10);
        f24066e.put("B", 11);
        f24066e.put("C", 12);
        f24066e.put("D", 13);
        f24066e.put("E", 14);
        f24066e.put("F", 15);
        f24066e.put("G", 16);
        f24066e.put("H", 17);
        f24066e.put("J", 18);
        f24066e.put("K", 19);
        f24066e.put("L", 20);
        f24066e.put("M", 21);
        f24066e.put("N", 22);
        f24066e.put("P", 23);
        f24066e.put("Q", 24);
        f24066e.put("R", 25);
        f24066e.put("S", 26);
        f24066e.put("T", 27);
        f24066e.put("U", 28);
        f24066e.put("V", 29);
        f24066e.put("X", 30);
        f24066e.put("Y", 31);
        f24066e.put("W", 32);
        f24066e.put("Z", 33);
        f24066e.put("I", 34);
        f24066e.put("O", 35);
        f24067f.put("A", 1);
        f24067f.put("B", 2);
        f24067f.put("C", 3);
        f24067f.put("R", 18);
        f24067f.put("U", 21);
        f24067f.put("Z", 26);
        f24067f.put("X", 24);
        f24067f.put("W", 23);
        f24067f.put("O", 15);
        f24067f.put("N", 14);
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
        for (int i2 = 0; i2 < length; i2++) {
            try {
                iArr[i2] = Integer.parseInt(String.valueOf(cArr[i2]));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return iArr;
    }

    public static int a(int[] iArr) {
        if (f24063b.length == iArr.length) {
            int i2 = 0;
            for (int i3 = 0; i3 < iArr.length; i3++) {
                int i4 = 0;
                while (true) {
                    int[] iArr2 = f24063b;
                    if (i4 < iArr2.length) {
                        if (i3 == i4) {
                            i2 += iArr[i3] * iArr2[i4];
                        }
                        i4++;
                    }
                }
            }
            return i2;
        }
        return 0;
    }

    public static String a(int i2) {
        switch (i2 % 11) {
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
