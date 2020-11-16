package com.baidu.tieba.sdk.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Context context, Map<String, String> map, SchemeCallback schemeCallback) {
        String str;
        String str2 = map.get("enterroom_type");
        String str3 = map.get(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
        String str4 = map.get("extra");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE, str3);
            jSONObject.put("extra", str4);
            str = jSONObject.toString();
        } catch (JSONException e) {
            str = "";
        }
        if (TextUtils.equals(str2, "1")) {
            com.baidu.tieba.sdk.a.dBW().aY(context, str);
        } else {
            com.baidu.tieba.sdk.a.dBW().aZ(context, str);
        }
    }
}
