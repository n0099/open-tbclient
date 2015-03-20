package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ah cuH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.cuH = ahVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public boolean onClick(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        if (z) {
            albumActivity2 = this.cuH.ctu;
            return albumActivity2.c(imageFileInfo);
        }
        albumActivity = this.cuH.ctu;
        return albumActivity.d(imageFileInfo);
    }
}
