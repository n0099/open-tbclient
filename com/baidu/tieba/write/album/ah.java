package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag fzH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.fzH = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.fzH.fyo;
            boolean c = albumActivity2.c(imageFileInfo);
            oVar = this.fzH.fxZ;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.fzH.fyo;
                albumActivity3.blx();
                return c;
            }
            return c;
        }
        albumActivity = this.fzH.fyo;
        return albumActivity.d(imageFileInfo);
    }
}
