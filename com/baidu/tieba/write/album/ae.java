package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements v {
    final /* synthetic */ ac dlo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.dlo = acVar;
    }

    @Override // com.baidu.tieba.write.album.v
    public void a(int i, ImageFileInfo imageFileInfo) {
        l lVar;
        AlbumActivity albumActivity;
        lVar = this.dlo.djP;
        lVar.lL(i);
        albumActivity = this.dlo.djW;
        albumActivity.lG(1);
    }
}
