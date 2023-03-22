package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class z11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(c21 c21Var) {
        InterceptResult invokeL;
        u11[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, c21Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (u11[] u11VarArr : c21Var.e()) {
                String[] strArr = new String[u11VarArr.length];
                for (int i = 0; i < u11VarArr.length; i++) {
                    strArr[i] = u11VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + c21Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + c21Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(c21 c21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c21Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + c21Var.g() + " (" + f(c21Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(u11[] u11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, u11VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = u11VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                u11 u11Var = u11VarArr[i];
                sb.append(str);
                sb.append(u11Var.b);
                sb.append(getType(u11Var));
                sb.append(c(u11Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(u11 u11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, u11Var)) == null) {
            int i = u11Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + u11Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(u11 u11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, u11Var)) == null) {
            int i = u11Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + u11Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(u11... u11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, u11VarArr)) == null) {
            return e(u11VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(u11[] u11VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, u11VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = u11VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                u11 u11Var = u11VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(u11Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
