package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedContentResource;
import tbclient.FeedItem;
import tbclient.FeedOriginComponent;
import tbclient.FeedOriginPic;
import tbclient.VideoField;
/* loaded from: classes9.dex */
public class zsc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedOriginComponent feedOriginComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedOriginComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (feedOriginComponent._abstract != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedContentResource feedContentResource : feedOriginComponent._abstract) {
                    jSONArray.put(gsc.b(feedContentResource));
                }
                qoc.a(jSONObject, "abstract", jSONArray);
            }
            FeedOriginPic feedOriginPic = feedOriginComponent.pic_info;
            if (feedOriginPic != null) {
                qoc.a(jSONObject, "pic_info", atc.b(feedOriginPic));
            }
            VideoField videoField = feedOriginComponent.video;
            if (videoField != null) {
                qoc.a(jSONObject, "video", y5d.b(videoField));
            }
            qoc.a(jSONObject, "schema", feedOriginComponent.schema);
            FeedItem feedItem = feedOriginComponent.item;
            if (feedItem != null) {
                qoc.a(jSONObject, "item", tsc.b(feedItem));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
