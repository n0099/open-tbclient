package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class aj implements y {
    final /* synthetic */ ah cuH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.cuH = ahVar;
    }

    @Override // com.baidu.tieba.write.album.y
    public void onClick(int i, ImageFileInfo imageFileInfo) {
        n nVar;
        AlbumActivity albumActivity;
        nVar = this.cuH.ctp;
        nVar.setCurrentIndex(i);
        albumActivity = this.cuH.ctu;
        albumActivity.iL(1);
    }
}
