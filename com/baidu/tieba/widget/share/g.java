package com.baidu.tieba.widget.share;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
class g implements IBaiduListener {
    private a a;
    private boolean b = true;
    private f c;

    public g(a aVar) {
        this.a = aVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a(f fVar) {
        this.c = fVar;
    }

    private void a() {
        if (this.b) {
            this.a.a();
            this.c.a();
            return;
        }
        this.a.c();
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        a();
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        a();
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONArray jSONArray) {
        a();
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        this.a.b();
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        if (this.b) {
            this.a.d();
        } else {
            this.a.d();
        }
    }
}
