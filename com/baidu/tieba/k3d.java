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
/* loaded from: classes7.dex */
public class k3d extends ltc {
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
                    jSONArray.put(exc.b(feedContentResource));
                }
                ltc.a(jSONObject, "title", jSONArray);
            }
            FeedPicAbstract feedPicAbstract = frsTopThreadComponent.pic_abstract;
            if (feedPicAbstract != null) {
                ltc.a(jSONObject, "pic_abstract", zxc.b(feedPicAbstract));
            }
            FeedAuthorSocial feedAuthorSocial = frsTopThreadComponent.author_social;
            if (feedAuthorSocial != null) {
                ltc.a(jSONObject, "author_social", zwc.b(feedAuthorSocial));
            }
            if (frsTopThreadComponent.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : frsTopThreadComponent.business_info) {
                    jSONArray2.put(sxc.b(feedKV));
                }
                ltc.a(jSONObject, "business_info", jSONArray2);
            }
            ltc.a(jSONObject, "scheme", frsTopThreadComponent.scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
