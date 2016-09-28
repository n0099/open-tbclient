package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ag gdz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.gdz = agVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void b(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        AlbumActivity albumActivity;
        oVar = this.gdz.gbZ;
        oVar.th(i);
        albumActivity = this.gdz.gco;
        albumActivity.ti(1);
    }
}
