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
public class j31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(m31 m31Var) {
        InterceptResult invokeL;
        e31[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, m31Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (e31[] e31VarArr : m31Var.e()) {
                String[] strArr = new String[e31VarArr.length];
                for (int i = 0; i < e31VarArr.length; i++) {
                    strArr[i] = e31VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + m31Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + m31Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(m31 m31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, m31Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + m31Var.g() + " (" + f(m31Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(e31[] e31VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, e31VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = e31VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                e31 e31Var = e31VarArr[i];
                sb.append(str);
                sb.append(e31Var.b);
                sb.append(getType(e31Var));
                sb.append(c(e31Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(e31 e31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, e31Var)) == null) {
            int i = e31Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + e31Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(e31 e31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, e31Var)) == null) {
            int i = e31Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + e31Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(e31... e31VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, e31VarArr)) == null) {
            return e(e31VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(e31[] e31VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, e31VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = e31VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                e31 e31Var = e31VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(e31Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
