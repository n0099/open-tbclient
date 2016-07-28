package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ea extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ ec eeA;
    final /* synthetic */ du eey;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(du duVar, ec ecVar, String str) {
        this.eey = duVar;
        this.eeA = ecVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        if (aVar == null) {
            this.eeA.eeK.setVisibility(8);
            this.eeA.eeL.setVisibility(8);
        } else if (aVar.cd()) {
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.auG = this.val$url;
            aVar2.auE = this.val$url;
            this.eeA.eeL.setVisibility(0);
            this.eeA.eeK.setVisibility(8);
            this.eeA.eeL.setScaleType(ImageView.ScaleType.FIT_XY);
            this.eeA.eeL.a(aVar2);
        } else {
            this.eeA.eeL.setVisibility(8);
            this.eeA.eeK.setVisibility(0);
            this.eeA.eeK.setScaleType(ImageView.ScaleType.FIT_XY);
            this.eeA.eeK.c(this.val$url, 17, false);
        }
    }
}
