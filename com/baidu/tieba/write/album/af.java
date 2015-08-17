package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class af implements w {
    final /* synthetic */ ad cRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar) {
        this.cRf = adVar;
    }

    @Override // com.baidu.tieba.write.album.w
    public void a(int i, ImageFileInfo imageFileInfo) {
        m mVar;
        AlbumActivity albumActivity;
        mVar = this.cRf.cPJ;
        mVar.kj(i);
        albumActivity = this.cRf.cPQ;
        albumActivity.ke(1);
    }
}
