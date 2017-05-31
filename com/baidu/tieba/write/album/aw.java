package com.baidu.tieba.write.album;

import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes.dex */
class aw implements Runnable {
    final /* synthetic */ TbCameraView fVI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(TbCameraView tbCameraView) {
        this.fVI = tbCameraView;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbCameraView.d dVar;
        TbCameraView.d dVar2;
        dVar = this.fVI.fVr;
        if (dVar != null) {
            dVar2 = this.fVI.fVr;
            dVar2.bnt();
        }
    }
}
