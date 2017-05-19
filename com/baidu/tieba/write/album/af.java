package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements w {
    final /* synthetic */ ac fNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ac acVar) {
        this.fNP = acVar;
    }

    @Override // com.baidu.tieba.write.album.w
    public void a(int i, ImageFileInfo imageFileInfo) {
        p pVar;
        AlbumActivity albumActivity;
        pVar = this.fNP.fLQ;
        pVar.sJ(i);
        albumActivity = this.fNP.fMg;
        albumActivity.sK(1);
    }
}
