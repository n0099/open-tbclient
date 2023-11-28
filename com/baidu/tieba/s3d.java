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
public class s3d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GoodsInfo goodsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, goodsInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", goodsInfo.id);
            ltc.a(jSONObject, "user_name", goodsInfo.user_name);
            ltc.a(jSONObject, RecommendDetailActivityConfig.USER_PORTRAIT, goodsInfo.user_portrait);
            ltc.a(jSONObject, MissonDetailsActivityConfig.THREAD_TITLE, goodsInfo.thread_title);
            ltc.a(jSONObject, "thread_pic", goodsInfo.thread_pic);
            ltc.a(jSONObject, "pop_window_text", goodsInfo.pop_window_text);
            ltc.a(jSONObject, "goods_style", goodsInfo.goods_style);
            if (goodsInfo.thread_pic_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                    jSONArray.put(z9d.b(threadPicList));
                }
                ltc.a(jSONObject, "thread_pic_list", jSONArray);
            }
            ltc.a(jSONObject, "label_visible", goodsInfo.label_visible);
            ltc.a(jSONObject, "label_text", goodsInfo.label_text);
            ltc.a(jSONObject, "rank_level", goodsInfo.rank_level);
            ltc.a(jSONObject, "thread_type", goodsInfo.thread_type);
            ltc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, goodsInfo.button_text);
            ltc.a(jSONObject, "card_desc", goodsInfo.card_desc);
            ltc.a(jSONObject, "card_tag", goodsInfo.card_tag);
            ltc.a(jSONObject, "width", goodsInfo.width);
            ltc.a(jSONObject, "height", goodsInfo.height);
            ltc.a(jSONObject, "label_measure", goodsInfo.label_measure);
            ltc.a(jSONObject, "thread_content", goodsInfo.thread_content);
            ltc.a(jSONObject, "lego_card", goodsInfo.lego_card);
            VideoInfo videoInfo = goodsInfo.video_info;
            if (videoInfo != null) {
                ltc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, dbd.b(videoInfo));
            }
            ltc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, goodsInfo.tag_name);
            ltc.a(jSONObject, "button_url", goodsInfo.button_url);
            ltc.a(jSONObject, "ad_source", goodsInfo.ad_source);
            ltc.a(jSONObject, "tag_name_url", goodsInfo.tag_name_url);
            ltc.a(jSONObject, "tag_name_wh", goodsInfo.tag_name_wh);
            ltc.a(jSONObject, "brand_icon", goodsInfo.brand_icon);
            ltc.a(jSONObject, "brand_icon_wh", goodsInfo.brand_icon_wh);
            AdCloseInfo adCloseInfo = goodsInfo.close_info;
            if (adCloseInfo != null) {
                ltc.a(jSONObject, GameGuideConfigInfo.KEY_CLOSE_INFO, wtc.b(adCloseInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
