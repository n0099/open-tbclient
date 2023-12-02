package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AlaShareInfo;
/* loaded from: classes6.dex */
public class juc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaShareInfo alaShareInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaShareInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "content", alaShareInfo.content);
            ktc.a(jSONObject, "share_user_count", alaShareInfo.share_user_count);
            ktc.a(jSONObject, "share_count", alaShareInfo.share_count);
            ktc.a(jSONObject, "record_tid", alaShareInfo.record_tid);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
