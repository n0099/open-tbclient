package com.baidu.tieba.write.album;

import com.baidu.tieba.write.album.TbCameraView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements TbCameraView.d {
    final /* synthetic */ ac fNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ac acVar) {
        this.fNP = acVar;
    }

    @Override // com.baidu.tieba.write.album.TbCameraView.d
    public void bmH() {
        this.fNP.lE(false);
    }

    @Override // com.baidu.tieba.write.album.TbCameraView.d
    public void blW() {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        albumActivity = this.fNP.fMg;
        if (albumActivity != null) {
            albumActivity2 = this.fNP.fMg;
            albumActivity2.blW();
        }
        this.fNP.bmz();
        this.fNP.lE(true);
        this.fNP.bmy();
    }
}
