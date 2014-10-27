package com.baidu.tieba.pb.main;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.h {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        bv bvVar;
        com.baidu.tieba.model.ar arVar;
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            if (obj != null) {
                bvVar = this.bvg.buL;
                bvVar.h(bitmap);
                arVar = this.bvg.ayz;
                arVar.dI(true);
            }
        }
    }
}
