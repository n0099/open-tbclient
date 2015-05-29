package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ak implements ab {
    final /* synthetic */ aj czp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.czp = ajVar;
    }

    @Override // com.baidu.tieba.write.album.ab
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        if (z) {
            albumActivity2 = this.czp.cxZ;
            return albumActivity2.c(imageFileInfo);
        }
        albumActivity = this.czp.cxZ;
        return albumActivity.d(imageFileInfo);
    }
}
