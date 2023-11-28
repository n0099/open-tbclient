package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;
import tbclient.FeedLayout;
import tbclient.FrsTopThreadCardLayout;
import tbclient.HeadcardLayout;
import tbclient.LayoutFactory;
import tbclient.SidewayLayout;
import tbclient.VideoDoubleRowLayout;
/* loaded from: classes7.dex */
public class n4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, layoutFactory)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, TtmlNode.TAG_LAYOUT, layoutFactory.layout);
            FeedLayout feedLayout = layoutFactory.feed;
            if (feedLayout != null) {
                ltc.a(jSONObject, "feed", txc.b(feedLayout));
            }
            SidewayLayout sidewayLayout = layoutFactory.sideway;
            if (sidewayLayout != null) {
                ltc.a(jSONObject, "sideway", e8d.b(sidewayLayout));
            }
            HeadcardLayout headcardLayout = layoutFactory.headcard;
            if (headcardLayout != null) {
                ltc.a(jSONObject, "headcard", w3d.b(headcardLayout));
            }
            FrsTopThreadCardLayout frsTopThreadCardLayout = layoutFactory.frs_top_thread_card;
            if (frsTopThreadCardLayout != null) {
                ltc.a(jSONObject, "frs_top_thread_card", j3d.b(frsTopThreadCardLayout));
            }
            VideoDoubleRowLayout videoDoubleRowLayout = layoutFactory.double_row_video;
            if (videoDoubleRowLayout != null) {
                ltc.a(jSONObject, "double_row_video", bbd.b(videoDoubleRowLayout));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
