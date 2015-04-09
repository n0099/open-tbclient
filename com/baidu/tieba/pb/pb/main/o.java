package com.baidu.tieba.pb.pb.main;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class o extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        cj cjVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                cjVar = this.bIJ.bIl;
                cjVar.k(bitmap);
                aVar = this.bIJ.aHK;
                aVar.eQ(true);
            }
        }
    }
}
