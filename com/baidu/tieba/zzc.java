package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MediaNum;
/* loaded from: classes9.dex */
public class zzc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MediaNum mediaNum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mediaNum)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "pic", mediaNum.pic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
