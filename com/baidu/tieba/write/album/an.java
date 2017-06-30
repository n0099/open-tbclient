package com.baidu.tieba.write.album;

import com.baidu.tieba.w;
import com.baidu.tieba.write.album.TbCameraView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements TbCameraView.a {
    final /* synthetic */ ac ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ac acVar) {
        this.ggh = acVar;
    }

    @Override // com.baidu.tieba.write.album.TbCameraView.a
    public void bsA() {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.ggh.gex;
        if (albumActivity != null) {
            albumActivity2 = this.ggh.gex;
            albumActivity3 = this.ggh.gex;
            albumActivity2.showToast(albumActivity3.getResources().getString(w.l.camera_permission_disabled));
        }
    }
}
