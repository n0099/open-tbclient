package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ad implements w {
    final /* synthetic */ ac dkO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.dkO = acVar;
    }

    @Override // com.baidu.tieba.write.album.w
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        l lVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.dkO.djw;
            boolean c = albumActivity2.c(imageFileInfo);
            lVar = this.dkO.djp;
            if (lVar.isOriginalImg()) {
                albumActivity3 = this.dkO.djw;
                albumActivity3.aAZ();
                return c;
            }
            return c;
        }
        albumActivity = this.dkO.djw;
        return albumActivity.d(imageFileInfo);
    }
}
