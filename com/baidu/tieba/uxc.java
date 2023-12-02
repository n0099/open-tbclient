package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedLiveComponent;
/* loaded from: classes8.dex */
public class uxc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedLiveComponent feedLiveComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedLiveComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "top_label", feedLiveComponent.top_label);
            ktc.a(jSONObject, "bottom_label", feedLiveComponent.bottom_label);
            ktc.a(jSONObject, "audience_label", feedLiveComponent.audience_label);
            ktc.a(jSONObject, NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL, feedLiveComponent.cover_url);
            ktc.a(jSONObject, "schema", feedLiveComponent.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
