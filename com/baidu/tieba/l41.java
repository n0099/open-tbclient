package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class l41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(o41 o41Var) {
        InterceptResult invokeL;
        g41[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, o41Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (g41[] g41VarArr : o41Var.e()) {
                String[] strArr = new String[g41VarArr.length];
                for (int i = 0; i < g41VarArr.length; i++) {
                    strArr[i] = g41VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + o41Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + o41Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(o41 o41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o41Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + o41Var.g() + " (" + f(o41Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(g41[] g41VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, g41VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = g41VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                g41 g41Var = g41VarArr[i];
                sb.append(str);
                sb.append(g41Var.b);
                sb.append(getType(g41Var));
                sb.append(c(g41Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(g41 g41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, g41Var)) == null) {
            int i = g41Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + g41Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(g41 g41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, g41Var)) == null) {
            int i = g41Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + g41Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(g41... g41VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, g41VarArr)) == null) {
            return e(g41VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(g41[] g41VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, g41VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = g41VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                g41 g41Var = g41VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(g41Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
