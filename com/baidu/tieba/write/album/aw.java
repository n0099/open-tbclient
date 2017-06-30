package com.baidu.tieba.write.album;

import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes.dex */
class aw implements Runnable {
    final /* synthetic */ TbCameraView ggt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(TbCameraView tbCameraView) {
        this.ggt = tbCameraView;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbCameraView.d dVar;
        TbCameraView.d dVar2;
        dVar = this.ggt.ggc;
        if (dVar != null) {
            dVar2 = this.ggt.ggc;
            dVar2.brQ();
        }
    }
}
