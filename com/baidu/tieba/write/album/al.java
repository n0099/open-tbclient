package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class al implements aa {
    final /* synthetic */ aj czp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.czp = ajVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public void a(int i, ImageFileInfo imageFileInfo) {
        p pVar;
        AlbumActivity albumActivity;
        pVar = this.czp.cxU;
        pVar.setCurrentIndex(i);
        albumActivity = this.czp.cxZ;
        albumActivity.jk(1);
    }
}
