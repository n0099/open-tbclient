package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ag eog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.eog = agVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        AlbumActivity albumActivity;
        oVar = this.eog.emG;
        oVar.py(i);
        albumActivity = this.eog.emU;
        albumActivity.ps(1);
    }
}
