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
public class t11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(w11 w11Var) {
        InterceptResult invokeL;
        o11[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, w11Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (o11[] o11VarArr : w11Var.e()) {
                String[] strArr = new String[o11VarArr.length];
                for (int i = 0; i < o11VarArr.length; i++) {
                    strArr[i] = o11VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + w11Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + w11Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(w11 w11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, w11Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + w11Var.g() + " (" + f(w11Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String f(o11[] o11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, o11VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = o11VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                o11 o11Var = o11VarArr[i];
                sb.append(str);
                sb.append(o11Var.b);
                sb.append(getType(o11Var));
                sb.append(c(o11Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(o11 o11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, o11Var)) == null) {
            int i = o11Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + o11Var.a);
        }
        return (String) invokeL.objValue;
    }

    public static String c(o11 o11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, o11Var)) == null) {
            int i = o11Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + o11Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(o11... o11VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, o11VarArr)) == null) {
            return e(o11VarArr, null);
        }
        return (String) invokeL.objValue;
    }

    public static String e(o11[] o11VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, o11VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = o11VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                o11 o11Var = o11VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(o11Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
