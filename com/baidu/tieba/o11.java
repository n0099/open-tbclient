package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class o11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(r11 r11Var) {
        InterceptResult invokeL;
        j11[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, r11Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (j11[] j11VarArr : r11Var.e()) {
                String[] strArr = new String[j11VarArr.length];
                for (int i = 0; i < j11VarArr.length; i++) {
                    strArr[i] = j11VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + r11Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + r11Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(r11 r11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, r11Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + r11Var.g() + " (" + f(r11Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(j11[] j11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, j11VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = j11VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                j11 j11Var = j11VarArr[i];
                sb.append(str);
                sb.append(j11Var.b);
                sb.append(getType(j11Var));
                sb.append(c(j11Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(j11 j11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, j11Var)) == null) {
            int i = j11Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + j11Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(j11 j11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, j11Var)) == null) {
            int i = j11Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + j11Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(j11... j11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, j11VarArr)) == null) {
            return e(j11VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(j11[] j11VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, j11VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = j11VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                j11 j11Var = j11VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(j11Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
