package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ad implements w {
    final /* synthetic */ ac dlo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.dlo = acVar;
    }

    @Override // com.baidu.tieba.write.album.w
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        l lVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.dlo.djW;
            boolean c = albumActivity2.c(imageFileInfo);
            lVar = this.dlo.djP;
            if (lVar.isOriginalImg()) {
                albumActivity3 = this.dlo.djW;
                albumActivity3.aBj();
                return c;
            }
            return c;
        }
        albumActivity = this.dlo.djW;
        return albumActivity.d(imageFileInfo);
    }
}
