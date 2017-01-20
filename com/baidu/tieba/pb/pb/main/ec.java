package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ec extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ dx elZ;
    private final /* synthetic */ ed emb;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(dx dxVar, ed edVar, String str) {
        this.elZ = dxVar;
        this.emb = edVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        if (aVar == null) {
            this.emb.emt.setVisibility(8);
            this.emb.emu.setVisibility(8);
        } else if (aVar.cW()) {
            GifInfo gifInfo = new GifInfo();
            gifInfo.mDynamicUrl = this.val$url;
            gifInfo.mSharpText = this.val$url;
            this.emb.emu.setVisibility(0);
            this.emb.emt.setVisibility(8);
            this.emb.emu.setScaleType(ImageView.ScaleType.FIT_XY);
            this.emb.emu.a(gifInfo);
        } else {
            this.emb.emu.setVisibility(8);
            this.emb.emt.setVisibility(0);
            this.emb.emt.setScaleType(ImageView.ScaleType.FIT_XY);
            this.emb.emt.c(this.val$url, 17, false);
        }
    }
}
