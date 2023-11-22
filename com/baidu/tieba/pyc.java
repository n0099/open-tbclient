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
public class pyc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GoodsInfo goodsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, goodsInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", goodsInfo.id);
            qoc.a(jSONObject, "user_name", goodsInfo.user_name);
            qoc.a(jSONObject, RecommendDetailActivityConfig.USER_PORTRAIT, goodsInfo.user_portrait);
            qoc.a(jSONObject, MissonDetailsActivityConfig.THREAD_TITLE, goodsInfo.thread_title);
            qoc.a(jSONObject, "thread_pic", goodsInfo.thread_pic);
            qoc.a(jSONObject, "pop_window_text", goodsInfo.pop_window_text);
            qoc.a(jSONObject, "goods_style", goodsInfo.goods_style);
            if (goodsInfo.thread_pic_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                    jSONArray.put(w4d.b(threadPicList));
                }
                qoc.a(jSONObject, "thread_pic_list", jSONArray);
            }
            qoc.a(jSONObject, "label_visible", goodsInfo.label_visible);
            qoc.a(jSONObject, "label_text", goodsInfo.label_text);
            qoc.a(jSONObject, "rank_level", goodsInfo.rank_level);
            qoc.a(jSONObject, "thread_type", goodsInfo.thread_type);
            qoc.a(jSONObject, GameGuideConfigInfo.KEY_BUTTON_TEXT, goodsInfo.button_text);
            qoc.a(jSONObject, "card_desc", goodsInfo.card_desc);
            qoc.a(jSONObject, "card_tag", goodsInfo.card_tag);
            qoc.a(jSONObject, "width", goodsInfo.width);
            qoc.a(jSONObject, "height", goodsInfo.height);
            qoc.a(jSONObject, "label_measure", goodsInfo.label_measure);
            qoc.a(jSONObject, "thread_content", goodsInfo.thread_content);
            qoc.a(jSONObject, "lego_card", goodsInfo.lego_card);
            VideoInfo videoInfo = goodsInfo.video_info;
            if (videoInfo != null) {
                qoc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, z5d.b(videoInfo));
            }
            qoc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, goodsInfo.tag_name);
            qoc.a(jSONObject, "button_url", goodsInfo.button_url);
            qoc.a(jSONObject, "ad_source", goodsInfo.ad_source);
            qoc.a(jSONObject, "tag_name_url", goodsInfo.tag_name_url);
            qoc.a(jSONObject, "tag_name_wh", goodsInfo.tag_name_wh);
            qoc.a(jSONObject, "brand_icon", goodsInfo.brand_icon);
            qoc.a(jSONObject, "brand_icon_wh", goodsInfo.brand_icon_wh);
            AdCloseInfo adCloseInfo = goodsInfo.close_info;
            if (adCloseInfo != null) {
                qoc.a(jSONObject, GameGuideConfigInfo.KEY_CLOSE_INFO, bpc.b(adCloseInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
