package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ed extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ dy eoW;
    private final /* synthetic */ ee eoY;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed(dy dyVar, ee eeVar, String str) {
        this.eoW = dyVar;
        this.eoY = eeVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        if (aVar == null) {
            this.eoY.ept.setVisibility(8);
            this.eoY.epu.setVisibility(8);
        } else if (aVar.ef()) {
            GifInfo gifInfo = new GifInfo();
            gifInfo.mDynamicUrl = this.val$url;
            gifInfo.mSharpText = this.val$url;
            this.eoY.epu.setVisibility(0);
            this.eoY.ept.setVisibility(8);
            this.eoY.epu.setScaleType(ImageView.ScaleType.FIT_XY);
            this.eoY.epu.a(gifInfo);
        } else {
            this.eoY.epu.setVisibility(8);
            this.eoY.ept.setVisibility(0);
            this.eoY.ept.setScaleType(ImageView.ScaleType.FIT_XY);
            this.eoY.ept.c(this.val$url, 17, false);
        }
    }
}
