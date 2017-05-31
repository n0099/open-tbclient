package com.baidu.tieba.write.album;

import com.baidu.tieba.write.album.TbCameraView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements TbCameraView.d {
    final /* synthetic */ ac fVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ac acVar) {
        this.fVw = acVar;
    }

    @Override // com.baidu.tieba.write.album.TbCameraView.d
    public void boe() {
        this.fVw.lX(false);
    }

    @Override // com.baidu.tieba.write.album.TbCameraView.d
    public void bnt() {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        albumActivity = this.fVw.fTN;
        if (albumActivity != null) {
            albumActivity2 = this.fVw.fTN;
            albumActivity2.bnt();
        }
        this.fVw.bnW();
        this.fVw.lX(true);
        this.fVw.bnV();
    }
}
