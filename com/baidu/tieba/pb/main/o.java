package com.baidu.tieba.pb.main;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class o extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        bz bzVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                bzVar = this.bAS.bAw;
                bzVar.j(bitmap);
                aVar = this.bAS.aBJ;
                aVar.eF(true);
            }
        }
    }
}
