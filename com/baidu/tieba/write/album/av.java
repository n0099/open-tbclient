package com.baidu.tieba.write.album;

import android.graphics.BitmapFactory;
import android.hardware.Camera;
import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes.dex */
class av implements Camera.PictureCallback {
    final /* synthetic */ TbCameraView fOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(TbCameraView tbCameraView) {
        this.fOb = tbCameraView;
    }

    @Override // android.hardware.Camera.PictureCallback
    public void onPictureTaken(byte[] bArr, Camera camera) {
        Camera camera2;
        TbCameraView.d dVar;
        TbCameraView.d dVar2;
        Camera camera3;
        if (bArr != null) {
            this.fOb.fNY = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            camera2 = this.fOb.mCamera;
            if (camera2 != null) {
                camera3 = this.fOb.mCamera;
                camera3.stopPreview();
            }
            this.fOb.fNS = false;
            dVar = this.fOb.fNK;
            if (dVar != null) {
                dVar2 = this.fOb.fNK;
                dVar2.bmH();
            }
        }
    }
}
