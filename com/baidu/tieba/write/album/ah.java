package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag eYU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.eYU = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.eYU.eXL;
            boolean c = albumActivity2.c(imageFileInfo);
            oVar = this.eYU.eXw;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.eYU.eXL;
                albumActivity3.bby();
                return c;
            }
            return c;
        }
        albumActivity = this.eYU.eXL;
        return albumActivity.d(imageFileInfo);
    }
}
