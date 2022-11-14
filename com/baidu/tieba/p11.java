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
public class p11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(s11 s11Var) {
        InterceptResult invokeL;
        k11[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, s11Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (k11[] k11VarArr : s11Var.e()) {
                String[] strArr = new String[k11VarArr.length];
                for (int i = 0; i < k11VarArr.length; i++) {
                    strArr[i] = k11VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + s11Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + s11Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(s11 s11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, s11Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + s11Var.g() + " (" + f(s11Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(k11[] k11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, k11VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = k11VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                k11 k11Var = k11VarArr[i];
                sb.append(str);
                sb.append(k11Var.b);
                sb.append(getType(k11Var));
                sb.append(c(k11Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(k11 k11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, k11Var)) == null) {
            int i = k11Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + k11Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(k11 k11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, k11Var)) == null) {
            int i = k11Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + k11Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(k11... k11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, k11VarArr)) == null) {
            return e(k11VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(k11[] k11VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, k11VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = k11VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                k11 k11Var = k11VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(k11Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
