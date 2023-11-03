package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ForumShowInfo;
import tbclient.ForumShowInfoTag;
/* loaded from: classes7.dex */
public class otc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumShowInfo forumShowInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumShowInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "content", forumShowInfo.content);
            ForumShowInfoTag forumShowInfoTag = forumShowInfo.tag;
            if (forumShowInfoTag != null) {
                poc.a(jSONObject, "tag", ptc.b(forumShowInfoTag));
            }
            poc.a(jSONObject, "show_type", forumShowInfo.show_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
