package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedAuthorSocial;
import tbclient.FeedContentResource;
import tbclient.FeedKV;
import tbclient.FeedPicAbstract;
import tbclient.FrsTopThreadComponent;
/* loaded from: classes6.dex */
public class j3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsTopThreadComponent frsTopThreadComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsTopThreadComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (frsTopThreadComponent.title != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedContentResource feedContentResource : frsTopThreadComponent.title) {
                    jSONArray.put(dxc.b(feedContentResource));
                }
                ktc.a(jSONObject, "title", jSONArray);
            }
            FeedPicAbstract feedPicAbstract = frsTopThreadComponent.pic_abstract;
            if (feedPicAbstract != null) {
                ktc.a(jSONObject, "pic_abstract", yxc.b(feedPicAbstract));
            }
            FeedAuthorSocial feedAuthorSocial = frsTopThreadComponent.author_social;
            if (feedAuthorSocial != null) {
                ktc.a(jSONObject, "author_social", ywc.b(feedAuthorSocial));
            }
            if (frsTopThreadComponent.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : frsTopThreadComponent.business_info) {
                    jSONArray2.put(rxc.b(feedKV));
                }
                ktc.a(jSONObject, "business_info", jSONArray2);
            }
            ktc.a(jSONObject, "scheme", frsTopThreadComponent.scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
