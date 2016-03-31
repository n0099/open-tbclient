package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag eIc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.eIc = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.eIc.eGS;
            boolean c = albumActivity2.c(imageFileInfo);
            oVar = this.eIc.eGD;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.eIc.eGS;
                albumActivity3.aZb();
                return c;
            }
            return c;
        }
        albumActivity = this.eIc.eGS;
        return albumActivity.d(imageFileInfo);
    }
}
