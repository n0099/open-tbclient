package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements v {
    final /* synthetic */ ac dkO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.dkO = acVar;
    }

    @Override // com.baidu.tieba.write.album.v
    public void a(int i, ImageFileInfo imageFileInfo) {
        l lVar;
        AlbumActivity albumActivity;
        lVar = this.dkO.djp;
        lVar.lJ(i);
        albumActivity = this.dkO.djw;
        albumActivity.lE(1);
    }
}
