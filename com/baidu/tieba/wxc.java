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
/* loaded from: classes8.dex */
public class wxc extends ktc {
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
                    jSONArray.put(dxc.b(feedContentResource));
                }
                ktc.a(jSONObject, "abstract", jSONArray);
            }
            FeedOriginPic feedOriginPic = feedOriginComponent.pic_info;
            if (feedOriginPic != null) {
                ktc.a(jSONObject, "pic_info", xxc.b(feedOriginPic));
            }
            VideoField videoField = feedOriginComponent.video;
            if (videoField != null) {
                ktc.a(jSONObject, "video", bbd.b(videoField));
            }
            ktc.a(jSONObject, "schema", feedOriginComponent.schema);
            FeedItem feedItem = feedOriginComponent.item;
            if (feedItem != null) {
                ktc.a(jSONObject, "item", qxc.b(feedItem));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
