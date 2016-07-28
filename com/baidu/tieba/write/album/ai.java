package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ag fRl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.fRl = agVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void b(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        AlbumActivity albumActivity;
        oVar = this.fRl.fPM;
        oVar.ss(i);
        albumActivity = this.fRl.fQb;
        albumActivity.st(1);
    }
}
