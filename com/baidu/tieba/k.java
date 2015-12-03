package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.j;
/* loaded from: classes.dex */
class k implements GifView.a {
    private final /* synthetic */ ImageView aFn;
    private final /* synthetic */ GifView aFo;
    private final /* synthetic */ long aFp;
    private final /* synthetic */ j.a aFq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ImageView imageView, GifView gifView, long j, j.a aVar) {
        this.aFn = imageView;
        this.aFo = gifView;
        this.aFp = j;
        this.aFq = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aFn.setVisibility(8);
        this.aFo.release();
        if (System.currentTimeMillis() - this.aFp > 3000) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.tZ().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aFq != null) {
            this.aFq.GJ();
        }
    }
}
