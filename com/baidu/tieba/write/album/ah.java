package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag fME;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.fME = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.fME.fLm;
            boolean c = albumActivity2.c(imageFileInfo);
            oVar = this.fME.fKY;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.fME.fLm;
                albumActivity3.bmI();
                return c;
            }
            return c;
        }
        albumActivity = this.fME.fLm;
        return albumActivity.d(imageFileInfo);
    }
}
