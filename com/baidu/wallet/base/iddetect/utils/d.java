package com.baidu.wallet.base.iddetect.utils;

import androidx.room.RoomMasterTable;
import com.baidu.location.Address;
import com.baidu.webkit.sdk.WebKitFactory;
import com.tencent.connect.common.Constants;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f23421a = {"11", "12", "13", "14", Constants.VIA_REPORT_TYPE_WPA_STATE, Constants.VIA_REPORT_TYPE_QQFAVORITES, Constants.VIA_REPORT_TYPE_DATALINE, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, EventType.GiftEventID.SEND_GIFT_TO_USER_FAIL, EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS, EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_FAIL, EventType.GiftEventID.LOAD_ALL_GIFT_SUCCESS, EventType.GiftEventID.LOAD_ALL_GIFT_FAIL, "36", "37", "41", RoomMasterTable.DEFAULT_ID, "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", WebKitFactory.OS_64, "65", "71", "81", "82", "91"};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f23422b = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f23423c = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, String> f23424d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, Integer> f23425e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, Integer> f23426f = new HashMap();

    static {
        f23424d.put("11", Address.Builder.BEI_JING);
        f23424d.put("12", Address.Builder.TIAN_JIN);
        f23424d.put("13", "河北");
        f23424d.put("14", "山西");
        f23424d.put(Constants.VIA_REPORT_TYPE_WPA_STATE, "内蒙古");
        f23424d.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, "辽宁");
        f23424d.put(Constants.VIA_REPORT_TYPE_DATALINE, "吉林");
        f23424d.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "黑龙江");
        f23424d.put(EventType.GiftEventID.SEND_GIFT_TO_USER_FAIL, Address.Builder.SHANG_HAI);
        f23424d.put(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS, "江苏");
        f23424d.put(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_FAIL, "浙江");
        f23424d.put(EventType.GiftEventID.LOAD_ALL_GIFT_SUCCESS, "安徽");
        f23424d.put(EventType.GiftEventID.LOAD_ALL_GIFT_FAIL, "福建");
        f23424d.put("36", "江西");
        f23424d.put("37", "山东");
        f23424d.put("41", "河南");
        f23424d.put(RoomMasterTable.DEFAULT_ID, "湖北");
        f23424d.put("43", "湖南");
        f23424d.put("44", "广东");
        f23424d.put("45", "广西");
        f23424d.put("46", "海南");
        f23424d.put("50", Address.Builder.CHONG_QIN);
        f23424d.put("51", "四川");
        f23424d.put("52", "贵州");
        f23424d.put("53", "云南");
        f23424d.put("54", "西藏");
        f23424d.put("61", "陕西");
        f23424d.put("62", "甘肃");
        f23424d.put("63", "青海");
        f23424d.put(WebKitFactory.OS_64, "宁夏");
        f23424d.put("65", "新疆");
        f23424d.put("71", "台湾");
        f23424d.put("81", "香港");
        f23424d.put("82", "澳门");
        f23424d.put("91", "国外");
        f23425e.put("A", 10);
        f23425e.put("B", 11);
        f23425e.put("C", 12);
        f23425e.put("D", 13);
        f23425e.put("E", 14);
        f23425e.put("F", 15);
        f23425e.put("G", 16);
        f23425e.put("H", 17);
        f23425e.put("J", 18);
        f23425e.put("K", 19);
        f23425e.put("L", 20);
        f23425e.put("M", 21);
        f23425e.put("N", 22);
        f23425e.put("P", 23);
        f23425e.put("Q", 24);
        f23425e.put("R", 25);
        f23425e.put("S", 26);
        f23425e.put("T", 27);
        f23425e.put("U", 28);
        f23425e.put("V", 29);
        f23425e.put("X", 30);
        f23425e.put("Y", 31);
        f23425e.put("W", 32);
        f23425e.put("Z", 33);
        f23425e.put("I", 34);
        f23425e.put("O", 35);
        f23426f.put("A", 1);
        f23426f.put("B", 2);
        f23426f.put("C", 3);
        f23426f.put("R", 18);
        f23426f.put("U", 21);
        f23426f.put("Z", 26);
        f23426f.put("X", 24);
        f23426f.put("W", 23);
        f23426f.put("O", 15);
        f23426f.put("N", 14);
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
        if (f23422b.length == iArr.length) {
            int i2 = 0;
            for (int i3 = 0; i3 < iArr.length; i3++) {
                int i4 = 0;
                while (true) {
                    int[] iArr2 = f23422b;
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
                return "9";
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
