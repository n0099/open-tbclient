package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dz extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ dt dSh;
    private final /* synthetic */ eb dSj;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(dt dtVar, eb ebVar, String str) {
        this.dSh = dtVar;
        this.dSj = ebVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        if (aVar == null) {
            this.dSj.dSt.setVisibility(8);
            this.dSj.dSu.setVisibility(8);
        } else if (aVar.ce()) {
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.atR = this.val$url;
            aVar2.atP = this.val$url;
            this.dSj.dSu.setVisibility(0);
            this.dSj.dSt.setVisibility(8);
            this.dSj.dSu.setScaleType(ImageView.ScaleType.FIT_XY);
            this.dSj.dSu.a(aVar2);
        } else {
            this.dSj.dSu.setVisibility(8);
            this.dSj.dSt.setVisibility(0);
            this.dSj.dSt.setScaleType(ImageView.ScaleType.FIT_XY);
            this.dSj.dSt.c(this.val$url, 17, false);
        }
    }
}
