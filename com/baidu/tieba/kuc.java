package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.BrandForumInfo;
import tbclient.FrsPage.HeadImgs;
import tbclient.OriForumInfo;
/* loaded from: classes7.dex */
public class kuc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BrandForumInfo brandForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, brandForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (brandForumInfo.relation_forum != null) {
                JSONArray jSONArray = new JSONArray();
                for (OriForumInfo oriForumInfo : brandForumInfo.relation_forum) {
                    jSONArray.put(q0d.b(oriForumInfo));
                }
                poc.a(jSONObject, "relation_forum", jSONArray);
            }
            HeadImgs headImgs = brandForumInfo.head_imgs;
            if (headImgs != null) {
                poc.a(jSONObject, "head_imgs", qvc.c(headImgs));
            }
            poc.a(jSONObject, "brand_desc", brandForumInfo.brand_desc);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, brandForumInfo.jump_url);
            poc.a(jSONObject, "jump_desc", brandForumInfo.jump_desc);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
