package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class sz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(vz0 vz0Var) {
        InterceptResult invokeL;
        nz0[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vz0Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (nz0[] nz0VarArr : vz0Var.e()) {
                String[] strArr = new String[nz0VarArr.length];
                for (int i = 0; i < nz0VarArr.length; i++) {
                    strArr[i] = nz0VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + vz0Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + vz0Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(vz0 vz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vz0Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + vz0Var.g() + " (" + g(vz0Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String d(nz0 nz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, nz0Var)) == null) {
            int i = nz0Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + nz0Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String g(nz0[] nz0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, nz0VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = nz0VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                nz0 nz0Var = nz0VarArr[i];
                sb.append(str);
                sb.append(nz0Var.b);
                sb.append(d(nz0Var));
                sb.append(c(nz0Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c(nz0 nz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, nz0Var)) == null) {
            int i = nz0Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + nz0Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String e(nz0... nz0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, nz0VarArr)) == null) {
            return f(nz0VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String f(nz0[] nz0VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, nz0VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = nz0VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                nz0 nz0Var = nz0VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(nz0Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
