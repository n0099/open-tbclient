package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BusinessAccountInfo;
/* loaded from: classes7.dex */
public class mvc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BusinessAccountInfo businessAccountInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, businessAccountInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, IMUserExtraData.KEY_IS_BUSINESS_ACCOUNT, businessAccountInfo.is_business_account);
            ktc.a(jSONObject, "is_forum_business_account", businessAccountInfo.is_forum_business_account);
            ktc.a(jSONObject, "business_name", businessAccountInfo.business_name);
            ktc.a(jSONObject, "identifi_explain", businessAccountInfo.identifi_explain);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
