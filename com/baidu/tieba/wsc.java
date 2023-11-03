package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedLiveComponent;
/* loaded from: classes8.dex */
public class wsc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedLiveComponent feedLiveComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedLiveComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "top_label", feedLiveComponent.top_label);
            poc.a(jSONObject, "bottom_label", feedLiveComponent.bottom_label);
            poc.a(jSONObject, "audience_label", feedLiveComponent.audience_label);
            poc.a(jSONObject, NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL, feedLiveComponent.cover_url);
            poc.a(jSONObject, "schema", feedLiveComponent.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
