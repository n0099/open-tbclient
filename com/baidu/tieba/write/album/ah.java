package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag gdz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.gdz = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.gdz.gco;
            boolean d = albumActivity2.d(imageFileInfo);
            oVar = this.gdz.gbZ;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.gdz.gco;
                albumActivity3.bsl();
                return d;
            }
            return d;
        }
        albumActivity = this.gdz.gco;
        return albumActivity.e(imageFileInfo);
    }
}
