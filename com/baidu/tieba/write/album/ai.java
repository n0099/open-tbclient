package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ag gbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.gbq = agVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void b(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        AlbumActivity albumActivity;
        oVar = this.gbq.fZQ;
        oVar.sT(i);
        albumActivity = this.gbq.gaf;
        albumActivity.sU(1);
    }
}
