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
public class qz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(tz0 tz0Var) {
        InterceptResult invokeL;
        lz0[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tz0Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (lz0[] lz0VarArr : tz0Var.e()) {
                String[] strArr = new String[lz0VarArr.length];
                for (int i = 0; i < lz0VarArr.length; i++) {
                    strArr[i] = lz0VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + tz0Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + tz0Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(tz0 tz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tz0Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + tz0Var.g() + " (" + g(tz0Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String d(lz0 lz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lz0Var)) == null) {
            int i = lz0Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + lz0Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String g(lz0[] lz0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, lz0VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = lz0VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                lz0 lz0Var = lz0VarArr[i];
                sb.append(str);
                sb.append(lz0Var.b);
                sb.append(d(lz0Var));
                sb.append(c(lz0Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c(lz0 lz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lz0Var)) == null) {
            int i = lz0Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + lz0Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String e(lz0... lz0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lz0VarArr)) == null) {
            return f(lz0VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String f(lz0[] lz0VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, lz0VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = lz0VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                lz0 lz0Var = lz0VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(lz0Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
