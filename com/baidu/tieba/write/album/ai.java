package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ag fIk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.fIk = agVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        AlbumActivity albumActivity;
        oVar = this.fIk.fGE;
        oVar.sN(i);
        albumActivity = this.fIk.fGS;
        albumActivity.sO(1);
    }
}
