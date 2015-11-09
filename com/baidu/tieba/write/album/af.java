package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class af implements y {
    final /* synthetic */ ae dmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.dmW = aeVar;
    }

    @Override // com.baidu.tieba.write.album.y
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        m mVar;
        AlbumActivity albumActivity3;
        if (z) {
            albumActivity2 = this.dmW.dlE;
            boolean c = albumActivity2.c(imageFileInfo);
            mVar = this.dmW.dlv;
            if (mVar.isOriginalImg()) {
                albumActivity3 = this.dmW.dlE;
                albumActivity3.aBV();
                return c;
            }
            return c;
        }
        albumActivity = this.dmW.dlE;
        return albumActivity.d(imageFileInfo);
    }
}
