package com.baidu.tieba.write.album;

import com.baidu.tieba.write.album.TbCameraView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements TbCameraView.d {
    final /* synthetic */ ac ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ac acVar) {
        this.ggh = acVar;
    }

    @Override // com.baidu.tieba.write.album.TbCameraView.d
    public void bsB() {
        this.ggh.my(false);
    }

    @Override // com.baidu.tieba.write.album.TbCameraView.d
    public void brQ() {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        albumActivity = this.ggh.gex;
        if (albumActivity != null) {
            albumActivity2 = this.ggh.gex;
            albumActivity2.brQ();
        }
        this.ggh.bst();
        this.ggh.my(true);
        this.ggh.bss();
    }
}
