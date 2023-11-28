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
public class xxc extends ltc {
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
                    jSONArray.put(exc.b(feedContentResource));
                }
                ltc.a(jSONObject, "abstract", jSONArray);
            }
            FeedOriginPic feedOriginPic = feedOriginComponent.pic_info;
            if (feedOriginPic != null) {
                ltc.a(jSONObject, "pic_info", yxc.b(feedOriginPic));
            }
            VideoField videoField = feedOriginComponent.video;
            if (videoField != null) {
                ltc.a(jSONObject, "video", cbd.b(videoField));
            }
            ltc.a(jSONObject, "schema", feedOriginComponent.schema);
            FeedItem feedItem = feedOriginComponent.item;
            if (feedItem != null) {
                ltc.a(jSONObject, "item", rxc.b(feedItem));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
