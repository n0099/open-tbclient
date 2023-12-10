package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.WorkCreatorInfo;
/* loaded from: classes7.dex */
public class pbd extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorkCreatorInfo workCreatorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, workCreatorInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, IMUserExtraData.KEY_AUTH_DESC, workCreatorInfo.auth_desc);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
