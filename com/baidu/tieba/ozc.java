package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LikeForumInfo;
/* loaded from: classes7.dex */
public class ozc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LikeForumInfo likeForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, likeForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "forum_name", likeForumInfo.forum_name);
            qoc.a(jSONObject, "forum_id", likeForumInfo.forum_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
