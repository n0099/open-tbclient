package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.CommonForum;
/* loaded from: classes8.dex */
public class uuc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CommonForum commonForum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, commonForum)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "common_forum", commonForum.common_forum);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
