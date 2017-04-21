package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ag fQJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.fQJ = agVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        AlbumActivity albumActivity;
        oVar = this.fQJ.fPd;
        oVar.sQ(i);
        albumActivity = this.fQJ.fPr;
        albumActivity.sR(1);
    }
}
