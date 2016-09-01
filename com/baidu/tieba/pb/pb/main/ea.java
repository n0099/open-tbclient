package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ea extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ du eqD;
    private final /* synthetic */ ec eqF;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(du duVar, ec ecVar, String str) {
        this.eqD = duVar;
        this.eqF = ecVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        if (aVar == null) {
            this.eqF.eqP.setVisibility(8);
            this.eqF.eqQ.setVisibility(8);
        } else if (aVar.cY()) {
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.axN = this.val$url;
            aVar2.axL = this.val$url;
            this.eqF.eqQ.setVisibility(0);
            this.eqF.eqP.setVisibility(8);
            this.eqF.eqQ.setScaleType(ImageView.ScaleType.FIT_XY);
            this.eqF.eqQ.a(aVar2);
        } else {
            this.eqF.eqQ.setVisibility(8);
            this.eqF.eqP.setVisibility(0);
            this.eqF.eqP.setScaleType(ImageView.ScaleType.FIT_XY);
            this.eqF.eqP.c(this.val$url, 17, false);
        }
    }
}
