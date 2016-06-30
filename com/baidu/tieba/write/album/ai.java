package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ag fDY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.fDY = agVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void b(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        AlbumActivity albumActivity;
        oVar = this.fDY.fCA;
        oVar.rX(i);
        albumActivity = this.fDY.fCP;
        albumActivity.rZ(1);
    }
}
