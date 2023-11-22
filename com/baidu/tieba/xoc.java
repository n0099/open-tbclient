package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes9.dex */
public class xoc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActPost actPost) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actPost)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (actPost.act_hot != null) {
                JSONArray jSONArray = new JSONArray();
                for (ActHot actHot : actPost.act_hot) {
                    jSONArray.put(voc.b(actHot));
                }
                qoc.a(jSONObject, "act_hot", jSONArray);
            }
            qoc.a(jSONObject, "list_head", actPost.list_head);
            if (actPost.link_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (LinkInfo linkInfo : actPost.link_info) {
                    jSONArray2.put(qzc.b(linkInfo));
                }
                qoc.a(jSONObject, "link_info", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
