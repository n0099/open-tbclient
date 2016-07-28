package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag fRl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.fRl = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.fRl.fQb;
            boolean d = albumActivity2.d(imageFileInfo);
            oVar = this.fRl.fPM;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.fRl.fQb;
                albumActivity3.bnp();
                return d;
            }
            return d;
        }
        albumActivity = this.fRl.fQb;
        return albumActivity.e(imageFileInfo);
    }
}
