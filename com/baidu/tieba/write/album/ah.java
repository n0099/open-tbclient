package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag fIk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.fIk = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.fIk.fGS;
            boolean c = albumActivity2.c(imageFileInfo);
            oVar = this.fIk.fGE;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.fIk.fGS;
                albumActivity3.bmV();
                return c;
            }
            return c;
        }
        albumActivity = this.fIk.fGS;
        return albumActivity.d(imageFileInfo);
    }
}
