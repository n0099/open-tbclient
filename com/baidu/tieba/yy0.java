package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class yy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(bz0 bz0Var) {
        InterceptResult invokeL;
        ty0[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bz0Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (ty0[] ty0VarArr : bz0Var.e()) {
                String[] strArr = new String[ty0VarArr.length];
                for (int i = 0; i < ty0VarArr.length; i++) {
                    strArr[i] = ty0VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + bz0Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + bz0Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(bz0 bz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bz0Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + bz0Var.g() + " (" + g(bz0Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String d(ty0 ty0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ty0Var)) == null) {
            int i = ty0Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + ty0Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String g(ty0[] ty0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ty0VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = ty0VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                ty0 ty0Var = ty0VarArr[i];
                sb.append(str);
                sb.append(ty0Var.b);
                sb.append(d(ty0Var));
                sb.append(c(ty0Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c(ty0 ty0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ty0Var)) == null) {
            int i = ty0Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + ty0Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String e(ty0... ty0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ty0VarArr)) == null) {
            return f(ty0VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String f(ty0[] ty0VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, ty0VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = ty0VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                ty0 ty0Var = ty0VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(ty0Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
