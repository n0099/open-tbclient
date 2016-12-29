package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ag fzH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.fzH = agVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        AlbumActivity albumActivity;
        oVar = this.fzH.fxZ;
        oVar.sc(i);
        albumActivity = this.fzH.fyo;
        albumActivity.sd(1);
    }
}
