package com.baidu.tieba.write.album;

import android.view.SurfaceHolder;
import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes.dex */
class au implements SurfaceHolder.Callback {
    final /* synthetic */ TbCameraView fVI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(TbCameraView tbCameraView) {
        this.fVI = tbCameraView;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        TbCameraView.c cVar;
        TbCameraView.c cVar2;
        boolean z;
        this.fVI.mSurfaceHolder = surfaceHolder;
        cVar = this.fVI.fVn;
        if (cVar != null) {
            cVar2 = this.fVI.fVn;
            if (cVar2.boc()) {
                TbCameraView tbCameraView = this.fVI;
                z = this.fVI.fOe;
                tbCameraView.lY(z);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.fVI.stopCamera();
    }
}
