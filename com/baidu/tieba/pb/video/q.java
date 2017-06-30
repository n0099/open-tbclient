package com.baidu.tieba.pb.video;

import android.graphics.Bitmap;
import com.baidu.adp.lib.guide.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements g.a {
    final /* synthetic */ l eKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.eKu = lVar;
    }

    @Override // com.baidu.adp.lib.guide.g.a
    public void fc() {
    }

    @Override // com.baidu.adp.lib.guide.g.a
    public void onDismiss() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        this.eKu.eKq = null;
        bitmap = this.eKu.eKr;
        if (bitmap != null) {
            bitmap2 = this.eKu.eKr;
            if (!bitmap2.isRecycled()) {
                bitmap3 = this.eKu.eKr;
                bitmap3.recycle();
            }
        }
        this.eKu.eKr = null;
    }
}
