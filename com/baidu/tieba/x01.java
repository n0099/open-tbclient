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
public class x01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList a(a11 a11Var) {
        InterceptResult invokeL;
        s01[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, a11Var)) == null) {
            ArrayList arrayList = new ArrayList(2);
            for (s01[] s01VarArr : a11Var.e()) {
                String[] strArr = new String[s01VarArr.length];
                for (int i = 0; i < s01VarArr.length; i++) {
                    strArr[i] = s01VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + a11Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + a11Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(a11 a11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, a11Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + a11Var.g() + " (" + f(a11Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(s01[] s01VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, s01VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = s01VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                s01 s01Var = s01VarArr[i];
                sb.append(str);
                sb.append(s01Var.b);
                sb.append(getType(s01Var));
                sb.append(c(s01Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(s01 s01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, s01Var)) == null) {
            int i = s01Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + s01Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(s01 s01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, s01Var)) == null) {
            int i = s01Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + s01Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(s01... s01VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, s01VarArr)) == null) {
            return e(s01VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(s01[] s01VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, s01VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = s01VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                s01 s01Var = s01VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(s01Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
