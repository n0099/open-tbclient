package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable JSONObject jSONObject, int i, int i2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{jSONObject, Integer.valueOf(i), Integer.valueOf(i2), str})) == null) {
            if (i != 0 && i2 != 0 && !xi.isEmpty(str)) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                try {
                    jSONObject.put(i + "-" + i2, str);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65537, null, i, i2) == null) {
            new StatisticItem("c13318").param("obj_source", i).param("obj_type", i2).eventStat();
        }
    }

    public static void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, null, i, i2) == null) {
            new StatisticItem("c13317").param("obj_source", i).param("obj_type", i2).eventStat();
        }
    }
}
