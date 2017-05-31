package com.baidu.tieba.write.album;

import android.view.ViewGroup;
import com.baidu.tieba.write.album.TbCameraView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements TbCameraView.b {
    final /* synthetic */ ac fVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ac acVar) {
        this.fVw = acVar;
    }

    @Override // com.baidu.tieba.write.album.TbCameraView.b
    public void br(int i, int i2) {
        int i3;
        int i4;
        int i5;
        TbCameraView tbCameraView;
        TbCameraView tbCameraView2;
        int i6;
        int i7;
        if (i != 0 && i2 != 0) {
            if ((i2 * 1.0f) / i >= 0.75f) {
                i6 = this.fVw.mScreenWidth;
                i3 = (int) (i6 * 1.3333334f * ((i2 * 1.0f) / i));
                i7 = this.fVw.mScreenWidth;
                i5 = (int) (i7 * 1.3333334f);
            } else {
                i3 = this.fVw.mScreenWidth;
                i4 = this.fVw.mScreenWidth;
                i5 = (int) (i4 * ((i * 1.0f) / i2));
            }
            tbCameraView = this.fVw.fUY;
            ViewGroup.LayoutParams layoutParams = tbCameraView.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i5;
            tbCameraView2 = this.fVw.fUY;
            tbCameraView2.setLayoutParams(layoutParams);
        }
    }
}
