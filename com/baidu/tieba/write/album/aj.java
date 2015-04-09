package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class aj implements y {
    final /* synthetic */ ah cuX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.cuX = ahVar;
    }

    @Override // com.baidu.tieba.write.album.y
    public void onClick(int i, ImageFileInfo imageFileInfo) {
        n nVar;
        AlbumActivity albumActivity;
        nVar = this.cuX.ctF;
        nVar.setCurrentIndex(i);
        albumActivity = this.cuX.ctK;
        albumActivity.iO(1);
    }
}
