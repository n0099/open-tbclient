package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class q implements GifView.a {
    private final /* synthetic */ ImageView aHP;
    private final /* synthetic */ GifView aHQ;
    private final /* synthetic */ long aHR;
    private final /* synthetic */ p.a aHS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ImageView imageView, GifView gifView, long j, p.a aVar) {
        this.aHP = imageView;
        this.aHQ = gifView;
        this.aHR = j;
        this.aHS = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aHP.setVisibility(8);
        this.aHQ.release();
        if (System.currentTimeMillis() - this.aHR > 3000) {
            com.baidu.tbadk.core.sharedPref.b.uO().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.uO().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aHS != null) {
            this.aHS.HZ();
        }
    }
}
