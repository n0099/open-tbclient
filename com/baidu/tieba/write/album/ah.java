package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag eYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.eYV = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.eYV.eXM;
            boolean c = albumActivity2.c(imageFileInfo);
            oVar = this.eYV.eXx;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.eYV.eXM;
                albumActivity3.bbr();
                return c;
            }
            return c;
        }
        albumActivity = this.eYV.eXM;
        return albumActivity.d(imageFileInfo);
    }
}
