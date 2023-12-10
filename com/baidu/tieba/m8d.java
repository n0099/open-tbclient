package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SkinInfo;
/* loaded from: classes7.dex */
public class m8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SkinInfo skinInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, skinInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "skin", skinInfo.skin);
            ltc.a(jSONObject, "skin_size", skinInfo.skin_size);
            ltc.a(jSONObject, "url", skinInfo.url);
            ltc.a(jSONObject, "obj_id", skinInfo.obj_id);
            ltc.a(jSONObject, "monitor_id", skinInfo.monitor_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
