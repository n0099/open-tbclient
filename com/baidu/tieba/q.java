package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class q implements GifView.a {
    private final /* synthetic */ ImageView aGW;
    private final /* synthetic */ GifView aGX;
    private final /* synthetic */ long aGY;
    private final /* synthetic */ p.a aGZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ImageView imageView, GifView gifView, long j, p.a aVar) {
        this.aGW = imageView;
        this.aGX = gifView;
        this.aGY = j;
        this.aGZ = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aGW.setVisibility(8);
        this.aGX.release();
        if (System.currentTimeMillis() - this.aGY > 3000) {
            com.baidu.tbadk.core.sharedPref.b.sR().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.sR().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aGZ != null) {
            this.aGZ.HO();
        }
    }
}
