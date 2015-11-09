package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ag implements x {
    final /* synthetic */ ae dmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.dmW = aeVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public void a(int i, ImageFileInfo imageFileInfo) {
        m mVar;
        AlbumActivity albumActivity;
        mVar = this.dmW.dlv;
        mVar.lZ(i);
        albumActivity = this.dmW.dlE;
        albumActivity.lU(1);
    }
}
