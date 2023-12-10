package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.PostInfo;
/* loaded from: classes6.dex */
public class k1d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PostInfo postInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, postInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "common_post_pic", postInfo.common_post_pic);
            ltc.a(jSONObject, "large_post_pic", postInfo.large_post_pic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
