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
public class m4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, layoutFactory)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, TtmlNode.TAG_LAYOUT, layoutFactory.layout);
            FeedLayout feedLayout = layoutFactory.feed;
            if (feedLayout != null) {
                ktc.a(jSONObject, "feed", sxc.b(feedLayout));
            }
            SidewayLayout sidewayLayout = layoutFactory.sideway;
            if (sidewayLayout != null) {
                ktc.a(jSONObject, "sideway", d8d.b(sidewayLayout));
            }
            HeadcardLayout headcardLayout = layoutFactory.headcard;
            if (headcardLayout != null) {
                ktc.a(jSONObject, "headcard", v3d.b(headcardLayout));
            }
            FrsTopThreadCardLayout frsTopThreadCardLayout = layoutFactory.frs_top_thread_card;
            if (frsTopThreadCardLayout != null) {
                ktc.a(jSONObject, "frs_top_thread_card", i3d.b(frsTopThreadCardLayout));
            }
            VideoDoubleRowLayout videoDoubleRowLayout = layoutFactory.double_row_video;
            if (videoDoubleRowLayout != null) {
                ktc.a(jSONObject, "double_row_video", abd.b(videoDoubleRowLayout));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
