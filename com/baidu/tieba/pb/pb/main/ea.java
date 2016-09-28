package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ea extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ du esD;
    private final /* synthetic */ ec esF;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(du duVar, ec ecVar, String str) {
        this.esD = duVar;
        this.esF = ecVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        if (aVar == null) {
            this.esF.esX.setVisibility(8);
            this.esF.esY.setVisibility(8);
        } else if (aVar.cY()) {
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.axq = this.val$url;
            aVar2.axo = this.val$url;
            this.esF.esY.setVisibility(0);
            this.esF.esX.setVisibility(8);
            this.esF.esY.setScaleType(ImageView.ScaleType.FIT_XY);
            this.esF.esY.a(aVar2);
        } else {
            this.esF.esY.setVisibility(8);
            this.esF.esX.setVisibility(0);
            this.esF.esX.setScaleType(ImageView.ScaleType.FIT_XY);
            this.esF.esX.c(this.val$url, 17, false);
        }
    }
}
