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
public class w01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(z01 z01Var) {
        InterceptResult invokeL;
        r01[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, z01Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (r01[] r01VarArr : z01Var.e()) {
                String[] strArr = new String[r01VarArr.length];
                for (int i = 0; i < r01VarArr.length; i++) {
                    strArr[i] = r01VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + z01Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + z01Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(z01 z01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, z01Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + z01Var.g() + " (" + f(z01Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String c(r01 r01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, r01Var)) == null) {
            int i = r01Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + r01Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(r01... r01VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, r01VarArr)) == null) ? e(r01VarArr, null) : (String) invokeL.objValue;
    }

    public static String e(r01[] r01VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, r01VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = r01VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                r01 r01Var = r01VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(r01Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String f(r01[] r01VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, r01VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = r01VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                r01 r01Var = r01VarArr[i];
                sb.append(str);
                sb.append(r01Var.b);
                sb.append(getType(r01Var));
                sb.append(c(r01Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(r01 r01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, r01Var)) == null) {
            int i = r01Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + r01Var.a);
        }
        return (String) invokeL.objValue;
    }
}
