package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ag eYU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.eYU = agVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        AlbumActivity albumActivity;
        oVar = this.eYU.eXw;
        oVar.qG(i);
        albumActivity = this.eYU.eXL;
        albumActivity.qI(1);
    }
}
