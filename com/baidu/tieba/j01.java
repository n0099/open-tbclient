package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class j01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(m01 m01Var) {
        InterceptResult invokeL;
        e01[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, m01Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (e01[] e01VarArr : m01Var.e()) {
                String[] strArr = new String[e01VarArr.length];
                for (int i = 0; i < e01VarArr.length; i++) {
                    strArr[i] = e01VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + m01Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + m01Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(m01 m01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, m01Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + m01Var.g() + " (" + f(m01Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String c(e01 e01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, e01Var)) == null) {
            int i = e01Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + e01Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(e01... e01VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, e01VarArr)) == null) ? e(e01VarArr, null) : (String) invokeL.objValue;
    }

    public static String e(e01[] e01VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, e01VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = e01VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                e01 e01Var = e01VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(e01Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String f(e01[] e01VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, e01VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = e01VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                e01 e01Var = e01VarArr[i];
                sb.append(str);
                sb.append(e01Var.b);
                sb.append(getType(e01Var));
                sb.append(c(e01Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(e01 e01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, e01Var)) == null) {
            int i = e01Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + e01Var.a);
        }
        return (String) invokeL.objValue;
    }
}
