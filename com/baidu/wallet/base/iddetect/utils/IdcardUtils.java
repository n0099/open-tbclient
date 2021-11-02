package com.baidu.wallet.base.iddetect.utils;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomMasterTable;
import com.baidu.location.Address;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import com.tencent.connect.common.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public final class IdcardUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHINA_ID_MAX_LENGTH = 18;
    public static final int CHINA_ID_MIN_LENGTH = 15;
    public static final String[] CITYCODE;
    public static final int MIN = 1930;
    public static final int[] POWER;
    public static final String[] VERIFYCODE;
    public static Map<String, String> cityCodes;
    public static Map<String, Integer> hkFirstCode;
    public static Map<String, Integer> twFirstCode;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-67677842, "Lcom/baidu/wallet/base/iddetect/utils/IdcardUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-67677842, "Lcom/baidu/wallet/base/iddetect/utils/IdcardUtils;");
                return;
            }
        }
        CITYCODE = new String[]{"11", "12", "13", "14", "15", "21", Constants.VIA_REPORT_TYPE_DATALINE, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "31", "32", "33", "34", "35", VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, PayConfig.PAYMENT_POS_KEY_MANGA, "41", RoomMasterTable.DEFAULT_ID, "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", WebKitFactory.OS_64, "65", "71", "81", "82", "91"};
        POWER = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        VERIFYCODE = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        cityCodes = new HashMap();
        twFirstCode = new HashMap();
        hkFirstCode = new HashMap();
        cityCodes.put("11", Address.Builder.BEI_JING);
        cityCodes.put("12", Address.Builder.TIAN_JIN);
        cityCodes.put("13", "河北");
        cityCodes.put("14", "山西");
        cityCodes.put("15", "内蒙古");
        cityCodes.put("21", "辽宁");
        cityCodes.put(Constants.VIA_REPORT_TYPE_DATALINE, "吉林");
        cityCodes.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "黑龙江");
        cityCodes.put("31", Address.Builder.SHANG_HAI);
        cityCodes.put("32", "江苏");
        cityCodes.put("33", "浙江");
        cityCodes.put("34", "安徽");
        cityCodes.put("35", "福建");
        cityCodes.put(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, "江西");
        cityCodes.put(PayConfig.PAYMENT_POS_KEY_MANGA, "山东");
        cityCodes.put("41", "河南");
        cityCodes.put(RoomMasterTable.DEFAULT_ID, "湖北");
        cityCodes.put("43", "湖南");
        cityCodes.put("44", "广东");
        cityCodes.put("45", "广西");
        cityCodes.put("46", "海南");
        cityCodes.put("50", Address.Builder.CHONG_QIN);
        cityCodes.put("51", "四川");
        cityCodes.put("52", "贵州");
        cityCodes.put("53", "云南");
        cityCodes.put("54", "西藏");
        cityCodes.put("61", "陕西");
        cityCodes.put("62", "甘肃");
        cityCodes.put("63", "青海");
        cityCodes.put(WebKitFactory.OS_64, "宁夏");
        cityCodes.put("65", "新疆");
        cityCodes.put("71", "台湾");
        cityCodes.put("81", "香港");
        cityCodes.put("82", "澳门");
        cityCodes.put("91", "国外");
        twFirstCode.put(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 10);
        twFirstCode.put("B", 11);
        twFirstCode.put("C", 12);
        twFirstCode.put("D", 13);
        twFirstCode.put(ExifInterface.LONGITUDE_EAST, 14);
        twFirstCode.put("F", 15);
        twFirstCode.put("G", 16);
        twFirstCode.put(IEruptionStrategyGroup.STRATEGY_MODIFIER_H, 17);
        twFirstCode.put("J", 18);
        twFirstCode.put("K", 19);
        twFirstCode.put("L", 20);
        twFirstCode.put("M", 21);
        twFirstCode.put("N", 22);
        twFirstCode.put("P", 23);
        twFirstCode.put("Q", 24);
        twFirstCode.put("R", 25);
        twFirstCode.put(ExifInterface.LATITUDE_SOUTH, 26);
        twFirstCode.put(ExifInterface.GPS_DIRECTION_TRUE, 27);
        twFirstCode.put("U", 28);
        twFirstCode.put(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, 29);
        twFirstCode.put("X", 30);
        twFirstCode.put("Y", 31);
        twFirstCode.put(ExifInterface.LONGITUDE_WEST, 32);
        twFirstCode.put("Z", 33);
        twFirstCode.put("I", 34);
        twFirstCode.put("O", 35);
        hkFirstCode.put(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 1);
        hkFirstCode.put("B", 2);
        hkFirstCode.put("C", 3);
        hkFirstCode.put("R", 18);
        hkFirstCode.put("U", 21);
        hkFirstCode.put("Z", 26);
        hkFirstCode.put("X", 24);
        hkFirstCode.put(ExifInterface.LONGITUDE_WEST, 23);
        hkFirstCode.put("O", 15);
        hkFirstCode.put("N", 14);
    }

    public IdcardUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String conver15CardTo18(String str) {
        InterceptResult invokeL;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.length() == 15 && isNum(str)) {
                try {
                    date = new SimpleDateFormat("yyMMdd").parse(str.substring(6, 12));
                } catch (ParseException e2) {
                    e2.printStackTrace();
                    date = null;
                }
                Calendar calendar = Calendar.getInstance();
                if (date != null) {
                    calendar.setTime(date);
                }
                String str2 = str.substring(0, 6) + String.valueOf(calendar.get(1)) + str.substring(8);
                char[] charArray = str2.toCharArray();
                if (charArray != null) {
                    String checkCode18 = getCheckCode18(getPowerSum(converCharToInt(charArray)));
                    if (checkCode18.length() > 0) {
                        return str2 + checkCode18;
                    }
                    return null;
                }
                return str2;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static int[] converCharToInt(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cArr)) == null) {
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

    public static int getAgeByIdCard(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null || str.length() < 15) {
                return 0;
            }
            if (str.length() == 15) {
                str = conver15CardTo18(str);
            }
            if (str != null) {
                return Calendar.getInstance().get(1) - Integer.valueOf(str.substring(6, 10)).intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String getBirthByIdCard(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (str == null) {
                return null;
            }
            Integer valueOf = Integer.valueOf(str.length());
            if (valueOf.intValue() < 15) {
                return null;
            }
            if (valueOf.intValue() == 15) {
                str = conver15CardTo18(str);
            }
            if (str != null) {
                return str.substring(6, 14);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getCheckCode18(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) {
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

    public static Short getDateByIdCard(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null) {
                return null;
            }
            Integer valueOf = Integer.valueOf(str.length());
            if (valueOf.intValue() < 15) {
                return null;
            }
            if (valueOf.intValue() == 15) {
                str = conver15CardTo18(str);
            }
            if (str != null) {
                return Short.valueOf(str.substring(12, 14));
            }
            return null;
        }
        return (Short) invokeL.objValue;
    }

    public static String getGenderByIdCard(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str == null) {
                return "N";
            }
            if (str.length() == 15) {
                str = conver15CardTo18(str);
            }
            return str == null ? "N" : Integer.parseInt(str.substring(16, 17)) % 2 != 0 ? "M" : "F";
        }
        return (String) invokeL.objValue;
    }

    public static Short getMonthByIdCard(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (str == null) {
                return null;
            }
            Integer valueOf = Integer.valueOf(str.length());
            if (valueOf.intValue() < 15) {
                return null;
            }
            if (valueOf.intValue() == 15) {
                str = conver15CardTo18(str);
            }
            if (str != null) {
                return Short.valueOf(str.substring(10, 12));
            }
            return null;
        }
        return (Short) invokeL.objValue;
    }

    public static int getPowerSum(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iArr)) == null) {
            if (POWER.length == iArr.length) {
                int i2 = 0;
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    int i4 = 0;
                    while (true) {
                        int[] iArr2 = POWER;
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

    public static String getProvinceByIdCard(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (str == null) {
                return null;
            }
            int length = str.length();
            return cityCodes.get((length == 15 || length == 18) ? str.substring(0, 2) : "");
        }
        return (String) invokeL.objValue;
    }

    public static Short getYearByIdCard(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (str == null) {
                return null;
            }
            Integer valueOf = Integer.valueOf(str.length());
            if (valueOf.intValue() < 15) {
                return null;
            }
            if (valueOf.intValue() == 15) {
                str = conver15CardTo18(str);
            }
            if (str != null) {
                return Short.valueOf(str.substring(6, 10));
            }
            return null;
        }
        return (Short) invokeL.objValue;
    }

    public static boolean isNum(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (str == null || "".equals(str)) {
                return false;
            }
            return isNumeric(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean isNumeric(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? Pattern.compile("[0-9]*").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean valiDate(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65551, null, i2, i3, i4)) == null) {
            int i6 = Calendar.getInstance().get(1);
            if (i2 < 1930 || i2 >= i6 || i3 < 1 || i3 > 12) {
                return false;
            }
            if (i3 != 2) {
                i5 = (i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) ? 30 : 31;
            } else {
                i5 = ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) && i2 > 1930 && i2 < i6 ? 29 : 28;
            }
            return i4 >= 1 && i4 <= i5;
        }
        return invokeIII.booleanValue;
    }

    public static boolean validateCard(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            String trim = str.trim();
            if (validateIdCard18(trim) || validateIdCard15(trim)) {
                return true;
            }
            String validateIdCard10 = validateIdCard10(trim);
            return validateIdCard10 != null && validateIdCard10.equals("true");
        }
        return invokeL.booleanValue;
    }

    public static boolean validateHKCard(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String validateIdCard10(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            String replaceAll = str.replaceAll("[\\(|\\)]", "");
            if (replaceAll.length() == 8 || replaceAll.length() == 9 || str.length() == 10) {
                if (str.matches("^{9}$")) {
                    System.out.println("11111");
                    String substring = str.substring(1, 2);
                    if (substring.equals("1")) {
                        System.out.println("MMMMMMM");
                    } else if (substring.equals("2")) {
                        System.out.println("FFFFFFF");
                    } else {
                        System.out.println("NNNN");
                        return "false";
                    }
                    if (validateTWCard(str)) {
                        return "true";
                    }
                } else if (str.matches("^{6}\\(?\\)?$")) {
                    return "N";
                } else {
                    if (!str.matches("^{1,2}{6}\\(?\\)?$")) {
                        return null;
                    }
                    if (validateHKCard(str)) {
                        return "true";
                    }
                }
                return "false";
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean validateIdCard15(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            if (str.length() == 15 && isNum(str)) {
                if (cityCodes.get(str.substring(0, 2)) == null) {
                    return false;
                }
                String substring = str.substring(6, 12);
                Date date = null;
                try {
                    date = new SimpleDateFormat(FastLoginFeature.SSOLoginType.YY).parse(substring.substring(0, 2));
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
                Calendar calendar = Calendar.getInstance();
                if (date != null) {
                    calendar.setTime(date);
                }
                return valiDate(calendar.get(1), Integer.valueOf(substring.substring(2, 4)).intValue(), Integer.valueOf(substring.substring(4, 6)).intValue());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean validateIdCard18(String str) {
        InterceptResult invokeL;
        char[] charArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            if (str.length() == 18) {
                String substring = str.substring(0, 17);
                String substring2 = str.substring(17, 18);
                if (!isNum(substring) || (charArray = substring.toCharArray()) == null) {
                    return false;
                }
                String checkCode18 = getCheckCode18(getPowerSum(converCharToInt(charArray)));
                return checkCode18.length() > 0 && checkCode18.equalsIgnoreCase(substring2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean validateTWCard(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            String substring = str.substring(0, 1);
            String substring2 = str.substring(1, 9);
            String substring3 = str.substring(9, 10);
            Integer num = twFirstCode.get(substring);
            Integer valueOf = Integer.valueOf((num.intValue() / 10) + ((num.intValue() % 10) * 9));
            char[] charArray = substring2.toCharArray();
            Integer num2 = 8;
            for (char c2 : charArray) {
                valueOf = Integer.valueOf(valueOf.intValue() + (Integer.valueOf(c2 + "").intValue() * num2.intValue()));
                num2 = Integer.valueOf(num2.intValue() - 1);
            }
            return (valueOf.intValue() % 10 == 0 ? 0 : 10 - (valueOf.intValue() % 10)) == Integer.valueOf(substring3).intValue();
        }
        return invokeL.booleanValue;
    }
}
