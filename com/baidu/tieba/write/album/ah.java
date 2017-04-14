package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag fOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.fOn = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.fOn.fMV;
            boolean c = albumActivity2.c(imageFileInfo);
            oVar = this.fOn.fMH;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.fOn.fMV;
                albumActivity3.bns();
                return c;
            }
            return c;
        }
        albumActivity = this.fOn.fMV;
        return albumActivity.d(imageFileInfo);
    }
}
