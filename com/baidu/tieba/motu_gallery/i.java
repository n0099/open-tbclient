package com.baidu.tieba.motu_gallery;

import android.os.Handler;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JigsawAlbumActivity f2028a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(JigsawAlbumActivity jigsawAlbumActivity) {
        this.f2028a = jigsawAlbumActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        this.f2028a.c();
        handler = this.f2028a.u;
        handler2 = this.f2028a.u;
        handler.sendMessage(handler2.obtainMessage(2));
    }
}
