package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ag gle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.gle = agVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void b(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        AlbumActivity albumActivity;
        oVar = this.gle.gjE;
        oVar.tD(i);
        albumActivity = this.gle.gjT;
        albumActivity.tE(1);
    }
}
