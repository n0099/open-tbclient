package com.baidu.tieba.write.album;

import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes.dex */
class aw implements Runnable {
    final /* synthetic */ TbCameraView fOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(TbCameraView tbCameraView) {
        this.fOb = tbCameraView;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbCameraView.d dVar;
        TbCameraView.d dVar2;
        dVar = this.fOb.fNK;
        if (dVar != null) {
            dVar2 = this.fOb.fNK;
            dVar2.blW();
        }
    }
}
