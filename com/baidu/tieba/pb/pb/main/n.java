package com.baidu.tieba.pb.pb.main;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class n extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ci ciVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                ciVar = this.bIv.bHY;
                ciVar.k(bitmap);
                aVar = this.bIv.aHC;
                aVar.eS(true);
            }
        }
    }
}
