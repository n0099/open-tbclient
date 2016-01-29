package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements aa {
    final /* synthetic */ ag eog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.eog = agVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.eog.emU;
            boolean a = albumActivity2.a(imageFileInfo);
            oVar = this.eog.emG;
            if (oVar.isOriginalImg()) {
                albumActivity3 = this.eog.emU;
                albumActivity3.aSA();
                return a;
            }
            return a;
        }
        albumActivity = this.eog.emU;
        return albumActivity.b(imageFileInfo);
    }
}
