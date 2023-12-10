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
public class lzc extends ltc {
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
                    jSONArray.put(u5d.b(oriForumInfo));
                }
                ltc.a(jSONObject, "relation_forum", jSONArray);
            }
            HeadImgs headImgs = brandForumInfo.head_imgs;
            if (headImgs != null) {
                ltc.a(jSONObject, "head_imgs", r0d.c(headImgs));
            }
            ltc.a(jSONObject, "brand_desc", brandForumInfo.brand_desc);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, brandForumInfo.jump_url);
            ltc.a(jSONObject, "jump_desc", brandForumInfo.jump_desc);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
