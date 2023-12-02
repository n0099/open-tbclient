package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
import tbclient.FrsPage.TopLiveDataPostList;
/* loaded from: classes7.dex */
public class p2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopLiveDataPostList topLiveDataPostList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topLiveDataPostList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "nickname", topLiveDataPostList.nickname);
            ktc.a(jSONObject, "content", topLiveDataPostList.content);
            ktc.a(jSONObject, PushConstants.SEQ_ID, topLiveDataPostList.seq_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
