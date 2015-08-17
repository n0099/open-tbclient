package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements x {
    final /* synthetic */ ad cRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.cRf = adVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        if (z) {
            albumActivity2 = this.cRf.cPQ;
            return albumActivity2.c(imageFileInfo);
        }
        albumActivity = this.cRf.cPQ;
        return albumActivity.d(imageFileInfo);
    }
}
