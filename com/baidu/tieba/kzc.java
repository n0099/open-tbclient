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
/* loaded from: classes7.dex */
public class kzc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, layoutFactory)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, TtmlNode.TAG_LAYOUT, layoutFactory.layout);
            FeedLayout feedLayout = layoutFactory.feed;
            if (feedLayout != null) {
                qoc.a(jSONObject, "feed", vsc.b(feedLayout));
            }
            SidewayLayout sidewayLayout = layoutFactory.sideway;
            if (sidewayLayout != null) {
                qoc.a(jSONObject, "sideway", b3d.b(sidewayLayout));
            }
            HeadcardLayout headcardLayout = layoutFactory.headcard;
            if (headcardLayout != null) {
                qoc.a(jSONObject, "headcard", tyc.b(headcardLayout));
            }
            FrsTopThreadCardLayout frsTopThreadCardLayout = layoutFactory.frs_top_thread_card;
            if (frsTopThreadCardLayout != null) {
                qoc.a(jSONObject, "frs_top_thread_card", gyc.b(frsTopThreadCardLayout));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
