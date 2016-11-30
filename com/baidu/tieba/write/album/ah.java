package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag gle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.gle = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.gle.gjT;
            boolean d = albumActivity2.d(imageFileInfo);
            oVar = this.gle.gjE;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.gle.gjT;
                albumActivity3.buG();
                return d;
            }
            return d;
        }
        albumActivity = this.gle.gjT;
        return albumActivity.e(imageFileInfo);
    }
}
