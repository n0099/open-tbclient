package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ActBtn;
import tbclient.DetailInfo;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class z3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TPointPost tPointPost) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tPointPost)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "is_tuiguang", tPointPost.is_tuiguang);
            poc.a(jSONObject, CriusAttrConstants.POSITION, tPointPost.position);
            poc.a(jSONObject, "template_id", tPointPost.template_id);
            poc.a(jSONObject, "template_type", tPointPost.template_type);
            if (tPointPost.act_btn != null) {
                JSONArray jSONArray = new JSONArray();
                for (ActBtn actBtn : tPointPost.act_btn) {
                    jSONArray.put(toc.b(actBtn));
                }
                poc.a(jSONObject, "act_btn", jSONArray);
            }
            if (tPointPost.t_imgs != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Timgs timgs : tPointPost.t_imgs) {
                    jSONArray2.put(b5d.b(timgs));
                }
                poc.a(jSONObject, "t_imgs", jSONArray2);
            }
            DetailInfo detailInfo = tPointPost.detail_info;
            if (detailInfo != null) {
                poc.a(jSONObject, "detail_info", orc.b(detailInfo));
            }
            poc.a(jSONObject, "monitor_id", tPointPost.monitor_id);
            poc.a(jSONObject, "hidden_day", tPointPost.hidden_day);
            VideoInfo videoInfo = tPointPost.t_video;
            if (videoInfo != null) {
                poc.a(jSONObject, "t_video", y5d.b(videoInfo));
            }
            poc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, tPointPost.tag_name);
            poc.a(jSONObject, "tag_name_url", tPointPost.tag_name_url);
            poc.a(jSONObject, "tag_name_wh", tPointPost.tag_name_wh);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
