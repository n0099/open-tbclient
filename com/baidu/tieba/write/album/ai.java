package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ag dMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.dMc = agVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        AlbumActivity albumActivity;
        oVar = this.dMc.dKx;
        oVar.nl(i);
        albumActivity = this.dMc.dKK;
        albumActivity.ng(1);
    }
}
