package com.baidu.tieba.write.album;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AlbumActivity cYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AlbumActivity albumActivity) {
        this.cYz = albumActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cYz.finish();
    }
}
