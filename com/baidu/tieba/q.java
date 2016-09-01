package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class q implements GifView.a {
    private final /* synthetic */ ImageView aLG;
    private final /* synthetic */ GifView aLH;
    private final /* synthetic */ long aLI;
    private final /* synthetic */ p.a aLJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ImageView imageView, GifView gifView, long j, p.a aVar) {
        this.aLG = imageView;
        this.aLH = gifView;
        this.aLI = j;
        this.aLJ = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aLG.setVisibility(8);
        this.aLH.release();
        if (System.currentTimeMillis() - this.aLI > 3000) {
            com.baidu.tbadk.core.sharedPref.b.tS().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.tS().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aLJ != null) {
            this.aLJ.onCompleted();
        }
    }
}
