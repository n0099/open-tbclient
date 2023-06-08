package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidCheckUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class oc5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String s = n95.m().s(SchemeForbidCheckUtils.SCHEME_WHITE_LIST_FILENAME, null);
            if (StringUtils.isNull(s)) {
                return null;
            }
            try {
                return b(new JSONArray(s));
            } catch (Exception unused) {
                return null;
            }
        }
        return (List) invokeV.objValue;
    }

    public static List<String> b(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONArray)) == null) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString = jSONArray.optString(i);
                if (!StringUtils.isNull(optString)) {
                    arrayList.add(optString);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, jSONArray) == null) {
            if (jSONArray == null) {
                n95.m().B(SchemeForbidCheckUtils.SCHEME_WHITE_LIST_FILENAME, "");
            } else {
                n95.m().B(SchemeForbidCheckUtils.SCHEME_WHITE_LIST_FILENAME, jSONArray.toString());
            }
        }
    }
}
