package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag dTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.dTB = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.dTB.dSj;
            boolean a = albumActivity2.a(imageFileInfo);
            oVar = this.dTB.dRW;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.dTB.dSj;
                albumActivity3.aJM();
                return a;
            }
            return a;
        }
        albumActivity = this.dTB.dSj;
        return albumActivity.b(imageFileInfo);
    }
}
