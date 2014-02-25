package com;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
import org.json.JSONObject;
/* loaded from: classes.dex */
class bb extends DefaultBaiduListener {
    final /* synthetic */ ShareMediaItem a;
    final /* synthetic */ ay b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ay ayVar, ShareMediaItem shareMediaItem) {
        this.b = ayVar;
        this.a = shareMediaItem;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        this.a.setUserName(jSONObject.optString("username"));
        this.b.notifyDataSetChanged();
    }
}
