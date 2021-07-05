package com.baidu.wallet.base.iddetect.utils;

import androidx.room.RoomMasterTable;
import com.baidu.location.Address;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebKitFactory;
import com.tencent.connect.common.Constants;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f23964a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f23965b;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f23966c;

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, String> f23967d;

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, Integer> f23968e;

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, Integer> f23969f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1531880272, "Lcom/baidu/wallet/base/iddetect/utils/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1531880272, "Lcom/baidu/wallet/base/iddetect/utils/d;");
                return;
            }
        }
        f23964a = new String[]{"11", "12", "13", "14", Constants.VIA_REPORT_TYPE_WPA_STATE, Constants.VIA_REPORT_TYPE_QQFAVORITES, Constants.VIA_REPORT_TYPE_DATALINE, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, EventType.GiftEventID.SEND_GIFT_TO_USER_FAIL, EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS, EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_FAIL, EventType.GiftEventID.LOAD_ALL_GIFT_SUCCESS, EventType.GiftEventID.LOAD_ALL_GIFT_FAIL, "36", "37", "41", RoomMasterTable.DEFAULT_ID, "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", WebKitFactory.OS_64, "65", "71", "81", "82", "91"};
        f23965b = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        f23966c = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        f23967d = new HashMap();
        f23968e = new HashMap();
        f23969f = new HashMap();
        f23967d.put("11", Address.Builder.BEI_JING);
        f23967d.put("12", Address.Builder.TIAN_JIN);
        f23967d.put("13", "河北");
        f23967d.put("14", "山西");
        f23967d.put(Constants.VIA_REPORT_TYPE_WPA_STATE, "内蒙古");
        f23967d.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, "辽宁");
        f23967d.put(Constants.VIA_REPORT_TYPE_DATALINE, "吉林");
        f23967d.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "黑龙江");
        f23967d.put(EventType.GiftEventID.SEND_GIFT_TO_USER_FAIL, Address.Builder.SHANG_HAI);
        f23967d.put(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS, "江苏");
        f23967d.put(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_FAIL, "浙江");
        f23967d.put(EventType.GiftEventID.LOAD_ALL_GIFT_SUCCESS, "安徽");
        f23967d.put(EventType.GiftEventID.LOAD_ALL_GIFT_FAIL, "福建");
        f23967d.put("36", "江西");
        f23967d.put("37", "山东");
        f23967d.put("41", "河南");
        f23967d.put(RoomMasterTable.DEFAULT_ID, "湖北");
        f23967d.put("43", "湖南");
        f23967d.put("44", "广东");
        f23967d.put("45", "广西");
        f23967d.put("46", "海南");
        f23967d.put("50", Address.Builder.CHONG_QIN);
        f23967d.put("51", "四川");
        f23967d.put("52", "贵州");
        f23967d.put("53", "云南");
        f23967d.put("54", "西藏");
        f23967d.put("61", "陕西");
        f23967d.put("62", "甘肃");
        f23967d.put("63", "青海");
        f23967d.put(WebKitFactory.OS_64, "宁夏");
        f23967d.put("65", "新疆");
        f23967d.put("71", "台湾");
        f23967d.put("81", "香港");
        f23967d.put("82", "澳门");
        f23967d.put("91", "国外");
        f23968e.put("A", 10);
        f23968e.put("B", 11);
        f23968e.put("C", 12);
        f23968e.put("D", 13);
        f23968e.put("E", 14);
        f23968e.put("F", 15);
        f23968e.put("G", 16);
        f23968e.put("H", 17);
        f23968e.put("J", 18);
        f23968e.put("K", 19);
        f23968e.put("L", 20);
        f23968e.put("M", 21);
        f23968e.put("N", 22);
        f23968e.put("P", 23);
        f23968e.put("Q", 24);
        f23968e.put("R", 25);
        f23968e.put("S", 26);
        f23968e.put("T", 27);
        f23968e.put("U", 28);
        f23968e.put("V", 29);
        f23968e.put("X", 30);
        f23968e.put("Y", 31);
        f23968e.put("W", 32);
        f23968e.put("Z", 33);
        f23968e.put("I", 34);
        f23968e.put("O", 35);
        f23969f.put("A", 1);
        f23969f.put("B", 2);
        f23969f.put("C", 3);
        f23969f.put("R", 18);
        f23969f.put("U", 21);
        f23969f.put("Z", 26);
        f23969f.put("X", 24);
        f23969f.put("W", 23);
        f23969f.put("O", 15);
        f23969f.put("N", 14);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        char[] charArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (str == null || "".equals(str)) {
                return false;
            }
            return c(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? Pattern.compile("[0-9]*").matcher(str).matches() : invokeL.booleanValue;
    }

    public static int[] a(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, cArr)) == null) {
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
        return (int[]) invokeL.objValue;
    }

    public static int a(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iArr)) == null) {
            if (f23965b.length == iArr.length) {
                int i2 = 0;
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    int i4 = 0;
                    while (true) {
                        int[] iArr2 = f23965b;
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
        return invokeL.intValue;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
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
        return (String) invokeI.objValue;
    }
}
