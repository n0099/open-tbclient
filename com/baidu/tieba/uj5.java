package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uj5 {
    public static /* synthetic */ Interceptable $ic;
    public static TextView a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean f(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Character.valueOf(c)})) == null) {
            if (c < 'a' || c > 'z') {
                if (c < 'A' || c > 'Z') {
                    return (c >= '0' && c <= '9') || c == ' ';
                }
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean g(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Character.valueOf(c)})) == null) ? c >= 55296 && c <= 56319 : invokeCommon.booleanValue;
    }

    public static int a(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Character.valueOf(c)})) == null) {
            if (f(c)) {
                return 1;
            }
            return 2;
        }
        return invokeCommon.intValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (f(str.charAt(i2))) {
                    i++;
                } else {
                    i += 2;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int codePointCount = str.codePointCount(0, str.length());
            int i = 0;
            for (int i2 = 1; i2 <= codePointCount; i2++) {
                str.substring(str.offsetByCodePoints(0, i2 - 1), str.offsetByCodePoints(0, i2)).length();
                i++;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (' ' == str.charAt(i2)) {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int codePointCount = str.codePointCount(0, str.length());
            int i = 0;
            for (int i2 = 1; i2 <= codePointCount; i2++) {
                String substring = str.substring(str.offsetByCodePoints(0, i2 - 1), str.offsetByCodePoints(0, i2));
                if (substring.length() >= 2) {
                    i += 2;
                } else {
                    i += b(substring);
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static String e(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (b(str) > i) {
                return j(str, 0, i - 2) + StringHelper.STRING_MORE;
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public static String k(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i)) == null) {
            int codePointCount = str.codePointCount(0, str.length());
            int i2 = 1;
            String str2 = str;
            while (i2 <= codePointCount) {
                String substring = str.substring(0, str.offsetByCodePoints(0, i2));
                if (c(substring) > i) {
                    break;
                }
                i2++;
                str2 = substring;
            }
            return str2;
        }
        return (String) invokeLI.objValue;
    }

    public static String l(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, str, i)) == null) {
            int codePointCount = str.codePointCount(0, str.length());
            int i2 = 1;
            String str2 = str;
            while (i2 <= codePointCount) {
                String substring = str.substring(0, str.offsetByCodePoints(0, i2));
                if (d(substring) > i) {
                    break;
                }
                i2++;
                str2 = substring;
            }
            return str2;
        }
        return (String) invokeLI.objValue;
    }

    public static Pair<Integer, Integer> h(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, str, i, i2)) == null) {
            try {
                if (a == null) {
                    a = new TextView(TbadkCoreApplication.getInst().getContext());
                }
                TextView textView = a;
                if (textView.getLayoutParams() == null) {
                    textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                }
                textView.setText(str);
                textView.setTextSize(0, i);
                textView.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                return new Pair<>(Integer.valueOf(textView.getMeasuredHeight()), Integer.valueOf(textView.getLineCount()));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Pair) invokeLII.objValue;
    }

    public static String j(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, str, i, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str) && i <= i2) {
                if (i >= 0 && i2 >= 0) {
                    int i3 = 0;
                    for (int i4 = 0; i4 < str.length(); i4++) {
                        char charAt = str.charAt(i4);
                        if (i3 >= i2) {
                            if (i3 == i2) {
                                if (g(sb.charAt(sb.length() - 1))) {
                                    sb.append(charAt);
                                    return sb.toString();
                                }
                                return sb.toString();
                            } else if (sb.length() > 2 && g(sb.charAt(sb.length() - 2))) {
                                return sb.toString();
                            } else {
                                return sb.deleteCharAt(sb.length() - 1).toString();
                            }
                        }
                        if (i3 >= i) {
                            sb.append(charAt);
                        }
                        if (f(charAt)) {
                            i3++;
                        } else {
                            i3 += 2;
                        }
                    }
                }
                return sb.toString();
            }
            return sb.toString();
        }
        return (String) invokeLII.objValue;
    }
}
