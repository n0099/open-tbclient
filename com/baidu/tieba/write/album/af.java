package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class af implements w {
    final /* synthetic */ ad cZQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar) {
        this.cZQ = adVar;
    }

    @Override // com.baidu.tieba.write.album.w
    public void a(int i, ImageFileInfo imageFileInfo) {
        m mVar;
        AlbumActivity albumActivity;
        mVar = this.cZQ.cYt;
        mVar.kU(i);
        albumActivity = this.cZQ.cYB;
        albumActivity.kP(1);
    }
}
