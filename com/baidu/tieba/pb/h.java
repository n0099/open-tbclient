package com.baidu.tieba.pb;

import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.view.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f1530a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ImageActivity imageActivity) {
        this.f1530a = imageActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void b_(int i) {
        boolean z;
        a aVar;
        z = this.f1530a.D;
        if (z) {
            Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pagechanged");
            intent.putExtra("index", -1);
            intent.putExtra("state", i);
            this.f1530a.sendBroadcast(intent);
        } else if (i == 0) {
            aVar = this.f1530a.w;
            aVar.b();
        }
    }
}
