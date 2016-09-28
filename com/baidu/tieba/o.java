package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class o implements GifView.a {
    private final /* synthetic */ ImageView aLa;
    private final /* synthetic */ GifView aLb;
    private final /* synthetic */ long aLc;
    private final /* synthetic */ n.a aLd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImageView imageView, GifView gifView, long j, n.a aVar) {
        this.aLa = imageView;
        this.aLb = gifView;
        this.aLc = j;
        this.aLd = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aLa.setVisibility(8);
        this.aLb.release();
        if (System.currentTimeMillis() - this.aLc > 3000) {
            com.baidu.tbadk.core.sharedPref.b.uh().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.uh().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aLd != null) {
            this.aLd.onCompleted();
        }
    }
}
