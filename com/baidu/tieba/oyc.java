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
/* loaded from: classes7.dex */
public class oyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GoodsInfo goodsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, goodsInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", goodsInfo.id);
            poc.a(jSONObject, "user_name", goodsInfo.user_name);
            poc.a(jSONObject, RecommendDetailActivityConfig.USER_PORTRAIT, goodsInfo.user_portrait);
            poc.a(jSONObject, MissonDetailsActivityConfig.THREAD_TITLE, goodsInfo.thread_title);
            poc.a(jSONObject, "thread_pic", goodsInfo.thread_pic);
            poc.a(jSONObject, "pop_window_text", goodsInfo.pop_window_text);
            poc.a(jSONObject, "goods_style", goodsInfo.goods_style);
            if (goodsInfo.thread_pic_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                    jSONArray.put(v4d.b(threadPicList));
                }
                poc.a(jSONObject, "thread_pic_list", jSONArray);
            }
            poc.a(jSONObject, "label_visible", goodsInfo.label_visible);
            poc.a(jSONObject, "label_text", goodsInfo.label_text);
            poc.a(jSONObject, "rank_level", goodsInfo.rank_level);
            poc.a(jSONObject, "thread_type", goodsInfo.thread_type);
            poc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, goodsInfo.button_text);
            poc.a(jSONObject, "card_desc", goodsInfo.card_desc);
            poc.a(jSONObject, "card_tag", goodsInfo.card_tag);
            poc.a(jSONObject, "width", goodsInfo.width);
            poc.a(jSONObject, "height", goodsInfo.height);
            poc.a(jSONObject, "label_measure", goodsInfo.label_measure);
            poc.a(jSONObject, "thread_content", goodsInfo.thread_content);
            poc.a(jSONObject, "lego_card", goodsInfo.lego_card);
            VideoInfo videoInfo = goodsInfo.video_info;
            if (videoInfo != null) {
                poc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, y5d.b(videoInfo));
            }
            poc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, goodsInfo.tag_name);
            poc.a(jSONObject, "button_url", goodsInfo.button_url);
            poc.a(jSONObject, "ad_source", goodsInfo.ad_source);
            poc.a(jSONObject, "tag_name_url", goodsInfo.tag_name_url);
            poc.a(jSONObject, "tag_name_wh", goodsInfo.tag_name_wh);
            poc.a(jSONObject, "brand_icon", goodsInfo.brand_icon);
            poc.a(jSONObject, "brand_icon_wh", goodsInfo.brand_icon_wh);
            AdCloseInfo adCloseInfo = goodsInfo.close_info;
            if (adCloseInfo != null) {
                poc.a(jSONObject, GameGuideConfigInfo.KEY_CLOSE_INFO, apc.b(adCloseInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
