package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ah cuX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.cuX = ahVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public boolean onClick(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        if (z) {
            albumActivity2 = this.cuX.ctK;
            return albumActivity2.c(imageFileInfo);
        }
        albumActivity = this.cuX.ctK;
        return albumActivity.d(imageFileInfo);
    }
}
