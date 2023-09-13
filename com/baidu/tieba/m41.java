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
public class m41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(p41 p41Var) {
        InterceptResult invokeL;
        h41[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, p41Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (h41[] h41VarArr : p41Var.e()) {
                String[] strArr = new String[h41VarArr.length];
                for (int i = 0; i < h41VarArr.length; i++) {
                    strArr[i] = h41VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + p41Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + p41Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(p41 p41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, p41Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + p41Var.g() + " (" + f(p41Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(h41[] h41VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, h41VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = h41VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                h41 h41Var = h41VarArr[i];
                sb.append(str);
                sb.append(h41Var.b);
                sb.append(getType(h41Var));
                sb.append(c(h41Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(h41 h41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, h41Var)) == null) {
            int i = h41Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + h41Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(h41 h41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, h41Var)) == null) {
            int i = h41Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + h41Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(h41... h41VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, h41VarArr)) == null) {
            return e(h41VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(h41[] h41VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, h41VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = h41VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                h41 h41Var = h41VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(h41Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
