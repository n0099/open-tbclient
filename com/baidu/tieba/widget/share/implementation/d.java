package com.baidu.tieba.widget.share.implementation;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class d implements IBaiduListener {
    private com.baidu.tieba.widget.share.a a;
    private boolean b = true;
    private c c;

    public d(com.baidu.tieba.widget.share.a aVar) {
        this.a = aVar;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final void a(c cVar) {
        this.c = cVar;
    }

    private void a() {
        if (this.b) {
            this.a.a();
            this.c.a();
            return;
        }
        this.a.b();
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public final void onComplete() {
        a();
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public final void onComplete(JSONObject jSONObject) {
        a();
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public final void onComplete(JSONArray jSONArray) {
        a();
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public final void onCancel() {
        com.baidu.tieba.widget.share.a aVar = this.a;
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public final void onError(BaiduException baiduException) {
        if (this.b) {
            com.baidu.tieba.widget.share.a aVar = this.a;
        } else {
            com.baidu.tieba.widget.share.a aVar2 = this.a;
        }
    }
}
