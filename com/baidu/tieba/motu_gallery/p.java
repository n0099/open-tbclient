package com.baidu.tieba.motu_gallery;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class p extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JigsawAlbumListActivity f2035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(JigsawAlbumListActivity jigsawAlbumListActivity) {
        this.f2035a = jigsawAlbumListActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.f2035a.a(message.arg1, (Bitmap) message.obj);
                return;
            default:
                return;
        }
    }
}
