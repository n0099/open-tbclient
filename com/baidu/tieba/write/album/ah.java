package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag fDY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.fDY = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.fDY.fCP;
            boolean d = albumActivity2.d(imageFileInfo);
            oVar = this.fDY.fCA;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.fDY.fCP;
                albumActivity3.bjT();
                return d;
            }
            return d;
        }
        albumActivity = this.fDY.fCP;
        return albumActivity.e(imageFileInfo);
    }
}
