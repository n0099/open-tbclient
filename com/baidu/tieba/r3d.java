package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.GoodsInfo;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class r3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GoodsInfo goodsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, goodsInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", goodsInfo.id);
            ktc.a(jSONObject, "user_name", goodsInfo.user_name);
            ktc.a(jSONObject, RecommendDetailActivityConfig.USER_PORTRAIT, goodsInfo.user_portrait);
            ktc.a(jSONObject, MissonDetailsActivityConfig.THREAD_TITLE, goodsInfo.thread_title);
            ktc.a(jSONObject, "thread_pic", goodsInfo.thread_pic);
            ktc.a(jSONObject, "pop_window_text", goodsInfo.pop_window_text);
            ktc.a(jSONObject, "goods_style", goodsInfo.goods_style);
            if (goodsInfo.thread_pic_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                    jSONArray.put(y9d.b(threadPicList));
                }
                ktc.a(jSONObject, "thread_pic_list", jSONArray);
            }
            ktc.a(jSONObject, "label_visible", goodsInfo.label_visible);
            ktc.a(jSONObject, "label_text", goodsInfo.label_text);
            ktc.a(jSONObject, "rank_level", goodsInfo.rank_level);
            ktc.a(jSONObject, "thread_type", goodsInfo.thread_type);
            ktc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, goodsInfo.button_text);
            ktc.a(jSONObject, "card_desc", goodsInfo.card_desc);
            ktc.a(jSONObject, "card_tag", goodsInfo.card_tag);
            ktc.a(jSONObject, "width", goodsInfo.width);
            ktc.a(jSONObject, "height", goodsInfo.height);
            ktc.a(jSONObject, "label_measure", goodsInfo.label_measure);
            ktc.a(jSONObject, "thread_content", goodsInfo.thread_content);
            ktc.a(jSONObject, "lego_card", goodsInfo.lego_card);
            VideoInfo videoInfo = goodsInfo.video_info;
            if (videoInfo != null) {
                ktc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, cbd.b(videoInfo));
            }
            ktc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, goodsInfo.tag_name);
            ktc.a(jSONObject, "button_url", goodsInfo.button_url);
            ktc.a(jSONObject, "ad_source", goodsInfo.ad_source);
            ktc.a(jSONObject, "tag_name_url", goodsInfo.tag_name_url);
            ktc.a(jSONObject, "tag_name_wh", goodsInfo.tag_name_wh);
            ktc.a(jSONObject, "brand_icon", goodsInfo.brand_icon);
            ktc.a(jSONObject, "brand_icon_wh", goodsInfo.brand_icon_wh);
            AdCloseInfo adCloseInfo = goodsInfo.close_info;
            if (adCloseInfo != null) {
                ktc.a(jSONObject, GameGuideConfigInfo.KEY_CLOSE_INFO, vtc.b(adCloseInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
