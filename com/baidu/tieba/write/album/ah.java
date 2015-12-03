package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag dMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.dMc = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.dMc.dKK;
            boolean a = albumActivity2.a(imageFileInfo);
            oVar = this.dMc.dKx;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.dMc.dKK;
                albumActivity3.aHs();
                return a;
            }
            return a;
        }
        albumActivity = this.dMc.dKK;
        return albumActivity.b(imageFileInfo);
    }
}
