package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.j;
/* loaded from: classes.dex */
class k implements GifView.a {
    private final /* synthetic */ ImageView aGN;
    private final /* synthetic */ GifView aGO;
    private final /* synthetic */ long aGP;
    private final /* synthetic */ j.a aGQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ImageView imageView, GifView gifView, long j, j.a aVar) {
        this.aGN = imageView;
        this.aGO = gifView;
        this.aGP = j;
        this.aGQ = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aGN.setVisibility(8);
        this.aGO.release();
        if (System.currentTimeMillis() - this.aGP > 3000) {
            com.baidu.tbadk.core.sharedPref.b.tJ().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.tJ().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aGQ != null) {
            this.aGQ.Gy();
        }
    }
}
