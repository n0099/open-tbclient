package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class lo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(ArrayList<String> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, arrayList, str, i)) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(arrayList)) {
                arrayList2.addAll(arrayList);
            }
            if (!TextUtils.isEmpty(str)) {
                arrayList2.add(str);
            }
            List<String> c = c(arrayList2, i);
            if (!ListUtils.isEmpty(c)) {
                return b(c);
            }
            return null;
        }
        return (String) invokeLLI.objValue;
    }

    public static String b(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (String str : list) {
                if (!StringUtils.isNull(str)) {
                    if (!z && !StringUtils.isNull(sb.toString())) {
                        z = true;
                    }
                    if (z) {
                        sb.append("_");
                    }
                    sb.append(str);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static List<String> c(List<String> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, list, i)) == null) {
            int count = ListUtils.getCount(list);
            if (count > 0 && i >= 0 && count > i) {
                return ListUtils.subList(list, count - i, count);
            }
            return list;
        }
        return (List) invokeLI.objValue;
    }
}
