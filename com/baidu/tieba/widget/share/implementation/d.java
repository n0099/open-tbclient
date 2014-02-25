package com.baidu.tieba.widget.share.implementation;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
class d implements IBaiduListener {
    private com.baidu.tieba.widget.share.a a;
    private boolean b = true;
    private c c;

    public d(com.baidu.tieba.widget.share.a aVar) {
        this.a = aVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a(c cVar) {
        this.c = cVar;
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
