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
public class xy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(az0 az0Var) {
        InterceptResult invokeL;
        sy0[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, az0Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (sy0[] sy0VarArr : az0Var.e()) {
                String[] strArr = new String[sy0VarArr.length];
                for (int i = 0; i < sy0VarArr.length; i++) {
                    strArr[i] = sy0VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + az0Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + az0Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(az0 az0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, az0Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + az0Var.g() + " (" + f(az0Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String c(sy0 sy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sy0Var)) == null) {
            int i = sy0Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + sy0Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(sy0... sy0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sy0VarArr)) == null) ? e(sy0VarArr, null) : (String) invokeL.objValue;
    }

    public static String e(sy0[] sy0VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, sy0VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = sy0VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                sy0 sy0Var = sy0VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(sy0Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String f(sy0[] sy0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, sy0VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = sy0VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                sy0 sy0Var = sy0VarArr[i];
                sb.append(str);
                sb.append(sy0Var.b);
                sb.append(getType(sy0Var));
                sb.append(c(sy0Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(sy0 sy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, sy0Var)) == null) {
            int i = sy0Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + sy0Var.a);
        }
        return (String) invokeL.objValue;
    }
}
