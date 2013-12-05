package com.baidu.tieba.widget.share;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
class g implements IBaiduListener {

    /* renamed from: a  reason: collision with root package name */
    private a f2758a;
    private boolean b = true;
    private f c;

    public g(a aVar) {
        this.f2758a = aVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a(f fVar) {
        this.c = fVar;
    }

    private void a() {
        if (this.b) {
            this.f2758a.a();
            this.c.a();
            return;
        }
        this.f2758a.c();
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
        this.f2758a.b();
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        if (this.b) {
            this.f2758a.d();
        } else {
            this.f2758a.d();
        }
    }
}
