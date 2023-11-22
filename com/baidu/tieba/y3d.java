package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes9.dex */
public class y3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SubPost subPost) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, subPost)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "pid", subPost.pid);
            if (subPost.sub_post_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (SubPostList subPostList : subPost.sub_post_list) {
                    jSONArray.put(z3d.b(subPostList));
                }
                qoc.a(jSONObject, "sub_post_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
