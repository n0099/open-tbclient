package com.baidu.tieba.pb.pb.main;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class n extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ch chVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                chVar = this.bKU.bKA;
                chVar.k(bitmap);
                aVar = this.bKU.aJU;
                aVar.fj(true);
            }
        }
    }
}
