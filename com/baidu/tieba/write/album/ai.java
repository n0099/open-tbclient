package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ag eIc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.eIc = agVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        AlbumActivity albumActivity;
        oVar = this.eIc.eGD;
        oVar.qr(i);
        albumActivity = this.eIc.eGS;
        albumActivity.qm(1);
    }
}
