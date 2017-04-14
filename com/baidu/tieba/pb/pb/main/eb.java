package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eb extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ dw ene;
    private final /* synthetic */ ec eng;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(dw dwVar, ec ecVar, String str) {
        this.ene = dwVar;
        this.eng = ecVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        if (aVar == null) {
            this.eng.enB.setVisibility(8);
            this.eng.enC.setVisibility(8);
        } else if (aVar.ee()) {
            GifInfo gifInfo = new GifInfo();
            gifInfo.mDynamicUrl = this.val$url;
            gifInfo.mSharpText = this.val$url;
            this.eng.enC.setVisibility(0);
            this.eng.enB.setVisibility(8);
            this.eng.enC.setScaleType(ImageView.ScaleType.FIT_XY);
            this.eng.enC.a(gifInfo);
        } else {
            this.eng.enC.setVisibility(8);
            this.eng.enB.setVisibility(0);
            this.eng.enB.setScaleType(ImageView.ScaleType.FIT_XY);
            this.eng.enB.c(this.val$url, 17, false);
        }
    }
}
