package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PrivatePopInfo;
/* loaded from: classes8.dex */
public class w6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PrivatePopInfo privatePopInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, privatePopInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "pop_type", privatePopInfo.pop_type);
            ktc.a(jSONObject, "pop_content", privatePopInfo.pop_content);
            ktc.a(jSONObject, "pop_url", privatePopInfo.pop_url);
            ktc.a(jSONObject, "pop_forum_id", privatePopInfo.pop_forum_id);
            ktc.a(jSONObject, "title", privatePopInfo.title);
            ktc.a(jSONObject, "day", privatePopInfo.day);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
