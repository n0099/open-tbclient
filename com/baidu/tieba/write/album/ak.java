package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ak implements ab {
    final /* synthetic */ aj czq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.czq = ajVar;
    }

    @Override // com.baidu.tieba.write.album.ab
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        if (z) {
            albumActivity2 = this.czq.cya;
            return albumActivity2.c(imageFileInfo);
        }
        albumActivity = this.czq.cya;
        return albumActivity.d(imageFileInfo);
    }
}
