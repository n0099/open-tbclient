package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements x {
    final /* synthetic */ ad cZQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.cZQ = adVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        if (z) {
            albumActivity2 = this.cZQ.cYB;
            return albumActivity2.c(imageFileInfo);
        }
        albumActivity = this.cZQ.cYB;
        return albumActivity.d(imageFileInfo);
    }
}
