package com;

import android.annotation.SuppressLint;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
class bu extends JsonHttpResponseHandler {
    final /* synthetic */ bs a;

    private bu(bs bsVar) {
        this.a = bsVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onFailure(Throwable th, String str) {
        this.a.f();
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONArray jSONArray) {
        if (this.a.d != null) {
            this.a.d.onComplete(jSONArray);
        }
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONObject jSONObject) {
        if (!jSONObject.has(SocialConstants.PARAM_ERROR_CODE)) {
            if (this.a.d != null) {
                this.a.d.onComplete(jSONObject);
                return;
            }
            return;
        }
        try {
            onFailure(new BaiduException(jSONObject.getInt(SocialConstants.PARAM_ERROR_CODE), jSONObject.getString("error_msg")), jSONObject.toString());
        } catch (JSONException e) {
            onFailure(e, jSONObject.toString());
        }
    }
}
