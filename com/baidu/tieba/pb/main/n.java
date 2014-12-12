package com.baidu.tieba.pb.main;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class n extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        bz bzVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                bzVar = this.bzj.byO;
                bzVar.j(bitmap);
                aVar = this.bzj.aAK;
                aVar.ey(true);
            }
        }
    }
}
