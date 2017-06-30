package com.baidu.tieba.write.album;

import android.view.SurfaceHolder;
import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes.dex */
class au implements SurfaceHolder.Callback {
    final /* synthetic */ TbCameraView ggt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(TbCameraView tbCameraView) {
        this.ggt = tbCameraView;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        TbCameraView.c cVar;
        TbCameraView.c cVar2;
        boolean z;
        this.ggt.mSurfaceHolder = surfaceHolder;
        cVar = this.ggt.gfY;
        if (cVar != null) {
            cVar2 = this.ggt.gfY;
            if (cVar2.bsz()) {
                TbCameraView tbCameraView = this.ggt;
                z = this.ggt.fXV;
                tbCameraView.mz(z);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.ggt.stopCamera();
    }
}
