package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AlaShareInfo;
/* loaded from: classes7.dex */
public class mpc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaShareInfo alaShareInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaShareInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "content", alaShareInfo.content);
            poc.a(jSONObject, "share_user_count", alaShareInfo.share_user_count);
            poc.a(jSONObject, "share_count", alaShareInfo.share_count);
            poc.a(jSONObject, "record_tid", alaShareInfo.record_tid);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
