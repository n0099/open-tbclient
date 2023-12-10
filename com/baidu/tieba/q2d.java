package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
import tbclient.FrsPage.TopLiveDataPostList;
/* loaded from: classes7.dex */
public class q2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopLiveDataPostList topLiveDataPostList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topLiveDataPostList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "nickname", topLiveDataPostList.nickname);
            ltc.a(jSONObject, "content", topLiveDataPostList.content);
            ltc.a(jSONObject, PushConstants.SEQ_ID, topLiveDataPostList.seq_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
