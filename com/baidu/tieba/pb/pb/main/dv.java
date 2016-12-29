package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dv extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ dq edg;
    private final /* synthetic */ dw edi;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(dq dqVar, dw dwVar, String str) {
        this.edg = dqVar;
        this.edi = dwVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        if (aVar == null) {
            this.edi.edz.setVisibility(8);
            this.edi.edA.setVisibility(8);
        } else if (aVar.cY()) {
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.axE = this.val$url;
            aVar2.axC = this.val$url;
            this.edi.edA.setVisibility(0);
            this.edi.edz.setVisibility(8);
            this.edi.edA.setScaleType(ImageView.ScaleType.FIT_XY);
            this.edi.edA.a(aVar2);
        } else {
            this.edi.edA.setVisibility(8);
            this.edi.edz.setVisibility(0);
            this.edi.edz.setScaleType(ImageView.ScaleType.FIT_XY);
            this.edi.edz.c(this.val$url, 17, false);
        }
    }
}
