package com.baidu.tieba.pb;

import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.view.a {
    final /* synthetic */ ImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ImageActivity imageActivity) {
        this.a = imageActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void a(int i) {
        Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pagechanged");
        intent.putExtra("index", -1);
        intent.putExtra("state", i);
        this.a.sendBroadcast(intent);
    }
}
