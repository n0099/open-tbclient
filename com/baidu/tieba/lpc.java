package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AlaLiveNotify;
/* loaded from: classes7.dex */
public class lpc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaLiveNotify alaLiveNotify) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaLiveNotify)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "noti_content", alaLiveNotify.noti_content);
            poc.a(jSONObject, "noti_url", alaLiveNotify.noti_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
