package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class q implements GifView.a {
    private final /* synthetic */ ImageView aKL;
    private final /* synthetic */ GifView aKM;
    private final /* synthetic */ long aKN;
    private final /* synthetic */ p.a aKO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ImageView imageView, GifView gifView, long j, p.a aVar) {
        this.aKL = imageView;
        this.aKM = gifView;
        this.aKN = j;
        this.aKO = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aKL.setVisibility(8);
        this.aKM.release();
        if (System.currentTimeMillis() - this.aKN > 3000) {
            com.baidu.tbadk.core.sharedPref.b.vk().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.vk().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aKO != null) {
            this.aKO.Jv();
        }
    }
}
