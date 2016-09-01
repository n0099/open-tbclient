package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag gbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.gbq = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.gbq.gaf;
            boolean d = albumActivity2.d(imageFileInfo);
            oVar = this.gbq.fZQ;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.gbq.gaf;
                albumActivity3.brF();
                return d;
            }
            return d;
        }
        albumActivity = this.gbq.gaf;
        return albumActivity.e(imageFileInfo);
    }
}
