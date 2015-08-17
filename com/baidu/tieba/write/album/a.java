package com.baidu.tieba.write.album;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AlbumActivity cPO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AlbumActivity albumActivity) {
        this.cPO = albumActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cPO.finish();
    }
}
