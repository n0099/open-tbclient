package com.baidu.tieba.pb;

import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.view.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f1568a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ImageActivity imageActivity) {
        this.f1568a = imageActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void b_(int i) {
        boolean z;
        a aVar;
        z = this.f1568a.D;
        if (z) {
            Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pagechanged");
            intent.putExtra("index", -1);
            intent.putExtra("state", i);
            this.f1568a.sendBroadcast(intent);
        } else if (i == 0) {
            aVar = this.f1568a.w;
            aVar.b();
        }
    }
}
