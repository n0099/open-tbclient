package com.baidu.tieba.write.album;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.StringUtils;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends com.baidu.tbadk.util.v<Object> {
    final /* synthetic */ TbCameraView fVI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(TbCameraView tbCameraView) {
        this.fVI = tbCameraView;
    }

    @Override // com.baidu.tbadk.util.v
    public Object doInBackground() {
        Bitmap bitmap;
        String str;
        boolean z;
        Bitmap bitmap2;
        String str2;
        Runnable runnable;
        bitmap = this.fVI.fVF;
        if (bitmap != null) {
            str = this.fVI.fVA;
            if (!StringUtils.isNull(str)) {
                z = this.fVI.fOe;
                int i = z ? -90 : 90;
                try {
                    TbCameraView tbCameraView = this.fVI;
                    bitmap2 = this.fVI.fVF;
                    Bitmap b = tbCameraView.b(bitmap2, i);
                    if (b != null) {
                        str2 = this.fVI.fVA;
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                        b.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        b.recycle();
                        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
                        runnable = this.fVI.mRunnable;
                        fS.post(runnable);
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
