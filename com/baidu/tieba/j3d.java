package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SkinInfo;
/* loaded from: classes6.dex */
public class j3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SkinInfo skinInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, skinInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "skin", skinInfo.skin);
            qoc.a(jSONObject, "skin_size", skinInfo.skin_size);
            qoc.a(jSONObject, "url", skinInfo.url);
            qoc.a(jSONObject, "obj_id", skinInfo.obj_id);
            qoc.a(jSONObject, "monitor_id", skinInfo.monitor_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
