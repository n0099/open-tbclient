package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag fQJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.fQJ = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.fQJ.fPr;
            boolean c = albumActivity2.c(imageFileInfo);
            oVar = this.fQJ.fPd;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.fQJ.fPr;
                albumActivity3.bot();
                return c;
            }
            return c;
        }
        albumActivity = this.fQJ.fPr;
        return albumActivity.d(imageFileInfo);
    }
}
