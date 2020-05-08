package com.baidu.tieba.sdk.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Context context, Map<String, String> map, SchemeCallback schemeCallback) {
        String str;
        String str2 = map.get(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
        if (TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE, str2);
                str = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                str = "";
            }
        }
        com.baidu.tieba.sdk.a.cPc().aP(context, str);
    }
}
