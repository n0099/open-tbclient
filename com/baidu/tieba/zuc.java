package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.FeedGroupInfo;
/* loaded from: classes9.dex */
public class zuc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedGroupInfo feedGroupInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedGroupInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "name", feedGroupInfo.name);
            qoc.a(jSONObject, BigdayActivityConfig.JUMP_URL, feedGroupInfo.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
