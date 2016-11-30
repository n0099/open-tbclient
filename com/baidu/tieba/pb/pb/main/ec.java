package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ec extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ dx eyV;
    private final /* synthetic */ ed eyX;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(dx dxVar, ed edVar, String str) {
        this.eyV = dxVar;
        this.eyX = edVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        if (aVar == null) {
            this.eyX.ezo.setVisibility(8);
            this.eyX.ezp.setVisibility(8);
        } else if (aVar.cY()) {
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.ayh = this.val$url;
            aVar2.ayf = this.val$url;
            this.eyX.ezp.setVisibility(0);
            this.eyX.ezo.setVisibility(8);
            this.eyX.ezp.setScaleType(ImageView.ScaleType.FIT_XY);
            this.eyX.ezp.a(aVar2);
        } else {
            this.eyX.ezp.setVisibility(8);
            this.eyX.ezo.setVisibility(0);
            this.eyX.ezo.setScaleType(ImageView.ScaleType.FIT_XY);
            this.eyX.ezo.c(this.val$url, 17, false);
        }
    }
}
