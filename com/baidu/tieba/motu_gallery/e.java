package com.baidu.tieba.motu_gallery;

import android.os.Handler;
/* loaded from: classes.dex */
final class e implements Runnable {
    final /* synthetic */ JigsawAlbumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(JigsawAlbumActivity jigsawAlbumActivity) {
        this.a = jigsawAlbumActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        JigsawAlbumActivity.e(this.a);
        handler = this.a.u;
        handler2 = this.a.u;
        handler.sendMessage(handler2.obtainMessage(2));
    }
}
