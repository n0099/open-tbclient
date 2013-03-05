package com.baidu.tieba.pb;

import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.view.a {
    final /* synthetic */ ImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ImageActivity imageActivity) {
        this.a = imageActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void a(int i) {
        boolean z;
        d dVar;
        z = this.a.D;
        if (z) {
            Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pagechanged");
            intent.putExtra("index", -1);
            intent.putExtra("state", i);
            this.a.sendBroadcast(intent);
        } else if (i == 0) {
            dVar = this.a.w;
            dVar.b();
        }
    }
}
