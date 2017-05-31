package com.baidu.tieba.pb.video;

import android.graphics.Bitmap;
import com.baidu.adp.lib.guide.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements g.a {
    final /* synthetic */ l eAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.eAW = lVar;
    }

    @Override // com.baidu.adp.lib.guide.g.a
    public void fd() {
    }

    @Override // com.baidu.adp.lib.guide.g.a
    public void onDismiss() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        this.eAW.eAS = null;
        bitmap = this.eAW.eAT;
        if (bitmap != null) {
            bitmap2 = this.eAW.eAT;
            if (!bitmap2.isRecycled()) {
                bitmap3 = this.eAW.eAT;
                bitmap3.recycle();
            }
        }
        this.eAW.eAT = null;
    }
}
