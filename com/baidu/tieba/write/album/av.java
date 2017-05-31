package com.baidu.tieba.write.album;

import android.graphics.BitmapFactory;
import android.hardware.Camera;
import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes.dex */
class av implements Camera.PictureCallback {
    final /* synthetic */ TbCameraView fVI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(TbCameraView tbCameraView) {
        this.fVI = tbCameraView;
    }

    @Override // android.hardware.Camera.PictureCallback
    public void onPictureTaken(byte[] bArr, Camera camera) {
        Camera camera2;
        TbCameraView.d dVar;
        TbCameraView.d dVar2;
        Camera camera3;
        if (bArr != null) {
            this.fVI.fVF = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            camera2 = this.fVI.mCamera;
            if (camera2 != null) {
                camera3 = this.fVI.mCamera;
                camera3.stopPreview();
            }
            this.fVI.fVz = false;
            dVar = this.fVI.fVr;
            if (dVar != null) {
                dVar2 = this.fVI.fVr;
                dVar2.boe();
            }
        }
    }
}
