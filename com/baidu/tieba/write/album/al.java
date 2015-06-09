package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class al implements aa {
    final /* synthetic */ aj czq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.czq = ajVar;
    }

    @Override // com.baidu.tieba.write.album.aa
    public void a(int i, ImageFileInfo imageFileInfo) {
        p pVar;
        AlbumActivity albumActivity;
        pVar = this.czq.cxV;
        pVar.setCurrentIndex(i);
        albumActivity = this.czq.cya;
        albumActivity.jk(1);
    }
}
