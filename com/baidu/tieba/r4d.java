package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LikeForumInfo;
/* loaded from: classes8.dex */
public class r4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LikeForumInfo likeForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, likeForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "forum_name", likeForumInfo.forum_name);
            ltc.a(jSONObject, "forum_id", likeForumInfo.forum_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
