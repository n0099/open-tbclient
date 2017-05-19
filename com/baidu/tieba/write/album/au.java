package com.baidu.tieba.write.album;

import android.view.SurfaceHolder;
import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes.dex */
class au implements SurfaceHolder.Callback {
    final /* synthetic */ TbCameraView fOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(TbCameraView tbCameraView) {
        this.fOb = tbCameraView;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        TbCameraView.c cVar;
        TbCameraView.c cVar2;
        boolean z;
        this.fOb.mSurfaceHolder = surfaceHolder;
        cVar = this.fOb.fNG;
        if (cVar != null) {
            cVar2 = this.fOb.fNG;
            if (cVar2.bmF()) {
                TbCameraView tbCameraView = this.fOb;
                z = this.fOb.fGk;
                tbCameraView.lF(z);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.fOb.stopCamera();
    }
}
