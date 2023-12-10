package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PrivatePopInfo;
/* loaded from: classes9.dex */
public class x6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PrivatePopInfo privatePopInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, privatePopInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "pop_type", privatePopInfo.pop_type);
            ltc.a(jSONObject, "pop_content", privatePopInfo.pop_content);
            ltc.a(jSONObject, "pop_url", privatePopInfo.pop_url);
            ltc.a(jSONObject, "pop_forum_id", privatePopInfo.pop_forum_id);
            ltc.a(jSONObject, "title", privatePopInfo.title);
            ltc.a(jSONObject, "day", privatePopInfo.day);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
