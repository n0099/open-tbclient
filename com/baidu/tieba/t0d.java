package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Level;
import tbclient.ParrProps;
import tbclient.Props;
/* loaded from: classes8.dex */
public class t0d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ParrProps parrProps) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, parrProps)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "portrait_time", parrProps.portrait_time);
            Level level = parrProps.level;
            if (level != null) {
                poc.a(jSONObject, "level", mzc.b(level));
            }
            if (parrProps.props != null) {
                JSONArray jSONArray = new JSONArray();
                for (Props props : parrProps.props) {
                    jSONArray.put(u1d.b(props));
                }
                poc.a(jSONObject, "props", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
