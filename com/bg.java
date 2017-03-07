package com;

import android.text.TextUtils;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.handler.FacebookShareHandler;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bg extends JsonHttpResponseHandler {
    final /* synthetic */ ShareContent a;
    final /* synthetic */ SessionManager.Session gny;
    final /* synthetic */ FacebookShareHandler kr;

    public bg(FacebookShareHandler facebookShareHandler, ShareContent shareContent, SessionManager.Session session) {
        this.kr = facebookShareHandler;
        this.a = shareContent;
        this.gny = session;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onFailure(Throwable th, String str) {
        this.kr.a(this.a, this.gny);
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("url");
            if (!TextUtils.isEmpty(string)) {
                this.a.setLinkUrl(string);
            }
        } catch (JSONException e) {
        }
        this.kr.a(this.a, this.gny);
    }
}
