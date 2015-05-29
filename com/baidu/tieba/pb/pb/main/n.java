package com.baidu.tieba.pb.pb.main;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class n extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ch chVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                chVar = this.bKT.bKz;
                chVar.k(bitmap);
                aVar = this.bKT.aJT;
                aVar.fj(true);
            }
        }
    }
}
