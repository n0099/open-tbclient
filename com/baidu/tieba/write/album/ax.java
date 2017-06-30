package com.baidu.tieba.write.album;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.StringUtils;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends com.baidu.tbadk.util.w<Object> {
    final /* synthetic */ TbCameraView ggt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(TbCameraView tbCameraView) {
        this.ggt = tbCameraView;
    }

    @Override // com.baidu.tbadk.util.w
    public Object doInBackground() {
        Bitmap bitmap;
        String str;
        boolean z;
        Bitmap bitmap2;
        String str2;
        Runnable runnable;
        bitmap = this.ggt.ggq;
        if (bitmap != null) {
            str = this.ggt.ggl;
            if (!StringUtils.isNull(str)) {
                z = this.ggt.fXV;
                int i = z ? -90 : 90;
                try {
                    TbCameraView tbCameraView = this.ggt;
                    bitmap2 = this.ggt.ggq;
                    Bitmap b = tbCameraView.b(bitmap2, i);
                    if (b != null) {
                        str2 = this.ggt.ggl;
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                        b.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        b.recycle();
                        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
                        runnable = this.ggt.mRunnable;
                        fR.post(runnable);
                        return null;
                    }
                    return null;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return null;
    }
}
