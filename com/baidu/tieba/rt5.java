package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class rt5 {
    public static /* synthetic */ Interceptable $ic;
    public static final long[] a;
    public static final String[] b;
    public static final String[] c;
    public static final String[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948133174, "Lcom/baidu/tieba/rt5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948133174, "Lcom/baidu/tieba/rt5;");
                return;
            }
        }
        a = new long[]{19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42416, 83315, 21168, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448, 84835, 37744, 18936, 18800, 25776, 92326, 59984, 27424, 108228, 43744, 41696, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 84821, 19296, 42352, 21732, 53600, 59752, 54560, 55968, 92838, 22224, 19168, 43476, 41680, 53584, 62034, 54560};
        b = new String[]{"", "正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬", "腊"};
        c = new String[]{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
        d = new String[]{"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
        new SimpleDateFormat("yyyy年M月d日 EEEEE");
    }

    public static final String a(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i == 10) {
                return "初十";
            }
            if (i == 20) {
                return "二十";
            }
            if (i == 30) {
                return "三十";
            }
            int i2 = i / 10;
            if (i2 == 0) {
                str = "初";
            } else {
                str = "";
            }
            if (i2 == 1) {
                str = "十";
            }
            if (i2 == 2) {
                str = "廿";
            }
            if (i2 == 3) {
                str = "三";
            }
            switch (i % 10) {
                case 1:
                    return str + "一";
                case 2:
                    return str + "二";
                case 3:
                    return str + "三";
                case 4:
                    return str + "四";
                case 5:
                    return str + "五";
                case 6:
                    return str + "六";
                case 7:
                    return str + "七";
                case 8:
                    return str + "八";
                case 9:
                    return str + "九";
                default:
                    return str;
            }
        }
        return (String) invokeI.objValue;
    }

    public static ArrayList<String> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i2 = 1; i2 <= i; i2++) {
                arrayList.add(a(i2));
            }
            return arrayList;
        }
        return (ArrayList) invokeI.objValue;
    }

    public static final int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (g(i) != 0) {
                if ((a[i - 1900] & 65536) != 0) {
                    return 30;
                }
                return 29;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public static final int g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            return (int) (a[i - 1900] & 15);
        }
        return invokeI.intValue;
    }

    public static String c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            StringBuilder sb = new StringBuilder();
            int i2 = i - 4;
            sb.append(c[i2 % 10]);
            sb.append(d[i2 % 12]);
            sb.append("年");
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public static ArrayList<String> d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i2 = 1; i2 < b.length; i2++) {
                arrayList.add(b[i2] + "月");
            }
            if (g(i) != 0) {
                int g = g(i);
                arrayList.add(g, "闰" + b[g(i)] + "月");
            }
            return arrayList;
        }
        return (ArrayList) invokeI.objValue;
    }

    public static ArrayList<String> e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            while (i < i2) {
                arrayList.add(String.format("%s(%d)", c(i), Integer.valueOf(i)));
                i++;
            }
            return arrayList;
        }
        return (ArrayList) invokeII.objValue;
    }

    public static final int h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65544, null, i, i2)) == null) {
            if (((65536 >> i2) & a[i - 1900]) == 0) {
                return 29;
            }
            return 30;
        }
        return invokeII.intValue;
    }
}
