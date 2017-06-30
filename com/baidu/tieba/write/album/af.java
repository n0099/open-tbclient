package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements w {
    final /* synthetic */ ac ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ac acVar) {
        this.ggh = acVar;
    }

    @Override // com.baidu.tieba.write.album.w
    public void a(int i, ImageFileInfo imageFileInfo) {
        p pVar;
        AlbumActivity albumActivity;
        pVar = this.ggh.gei;
        pVar.tz(i);
        albumActivity = this.ggh.gex;
        albumActivity.tA(1);
    }
}
