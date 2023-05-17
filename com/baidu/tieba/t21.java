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
public class t21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(w21 w21Var) {
        InterceptResult invokeL;
        o21[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, w21Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (o21[] o21VarArr : w21Var.e()) {
                String[] strArr = new String[o21VarArr.length];
                for (int i = 0; i < o21VarArr.length; i++) {
                    strArr[i] = o21VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + w21Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + w21Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(w21 w21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, w21Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + w21Var.g() + " (" + f(w21Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(o21[] o21VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, o21VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = o21VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                o21 o21Var = o21VarArr[i];
                sb.append(str);
                sb.append(o21Var.b);
                sb.append(getType(o21Var));
                sb.append(c(o21Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(o21 o21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, o21Var)) == null) {
            int i = o21Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + o21Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(o21 o21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, o21Var)) == null) {
            int i = o21Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + o21Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(o21... o21VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, o21VarArr)) == null) {
            return e(o21VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(o21[] o21VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, o21VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = o21VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                o21 o21Var = o21VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(o21Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
