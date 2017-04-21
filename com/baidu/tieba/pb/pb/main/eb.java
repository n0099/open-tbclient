package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eb extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ dw epw;
    private final /* synthetic */ ec epy;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(dw dwVar, ec ecVar, String str) {
        this.epw = dwVar;
        this.epy = ecVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        if (aVar == null) {
            this.epy.epT.setVisibility(8);
            this.epy.epU.setVisibility(8);
        } else if (aVar.ef()) {
            GifInfo gifInfo = new GifInfo();
            gifInfo.mDynamicUrl = this.val$url;
            gifInfo.mSharpText = this.val$url;
            this.epy.epU.setVisibility(0);
            this.epy.epT.setVisibility(8);
            this.epy.epU.setScaleType(ImageView.ScaleType.FIT_XY);
            this.epy.epU.a(gifInfo);
        } else {
            this.epy.epU.setVisibility(8);
            this.epy.epT.setVisibility(0);
            this.epy.epT.setScaleType(ImageView.ScaleType.FIT_XY);
            this.epy.epT.c(this.val$url, 17, false);
        }
    }
}
