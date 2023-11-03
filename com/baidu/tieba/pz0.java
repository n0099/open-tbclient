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
public class pz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(sz0 sz0Var) {
        InterceptResult invokeL;
        kz0[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sz0Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (kz0[] kz0VarArr : sz0Var.e()) {
                String[] strArr = new String[kz0VarArr.length];
                for (int i = 0; i < kz0VarArr.length; i++) {
                    strArr[i] = kz0VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + sz0Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + sz0Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(sz0 sz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sz0Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + sz0Var.g() + " (" + g(sz0Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String d(kz0 kz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, kz0Var)) == null) {
            int i = kz0Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + kz0Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String g(kz0[] kz0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, kz0VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = kz0VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                kz0 kz0Var = kz0VarArr[i];
                sb.append(str);
                sb.append(kz0Var.b);
                sb.append(d(kz0Var));
                sb.append(c(kz0Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c(kz0 kz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, kz0Var)) == null) {
            int i = kz0Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + kz0Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String e(kz0... kz0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, kz0VarArr)) == null) {
            return f(kz0VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String f(kz0[] kz0VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, kz0VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = kz0VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                kz0 kz0Var = kz0VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(kz0Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
