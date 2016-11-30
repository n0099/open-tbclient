package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class o implements GifView.a {
    private final /* synthetic */ ImageView aLR;
    private final /* synthetic */ GifView aLS;
    private final /* synthetic */ long aLT;
    private final /* synthetic */ n.a aLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImageView imageView, GifView gifView, long j, n.a aVar) {
        this.aLR = imageView;
        this.aLS = gifView;
        this.aLT = j;
        this.aLU = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aLR.setVisibility(8);
        this.aLS.release();
        if (System.currentTimeMillis() - this.aLT > 3000) {
            com.baidu.tbadk.core.sharedPref.b.um().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.um().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aLU != null) {
            this.aLU.onCompleted();
        }
    }
}
