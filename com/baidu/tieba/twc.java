package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Esport;
import tbclient.EsportRank;
import tbclient.EsportStatic;
/* loaded from: classes8.dex */
public class twc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Esport esport) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, esport)) == null) {
            JSONObject jSONObject = new JSONObject();
            EsportStatic esportStatic = esport._static;
            if (esportStatic != null) {
                ktc.a(jSONObject, "static", wwc.b(esportStatic));
            }
            ktc.a(jSONObject, "floor_no", esport.floor_no);
            if (esport.billboard != null) {
                JSONArray jSONArray = new JSONArray();
                for (EsportRank esportRank : esport.billboard) {
                    jSONArray.put(vwc.b(esportRank));
                }
                ktc.a(jSONObject, "billboard", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
