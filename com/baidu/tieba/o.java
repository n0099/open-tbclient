package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class o implements GifView.a {
    private final /* synthetic */ ImageView aKk;
    private final /* synthetic */ GifView aKl;
    private final /* synthetic */ long aKm;
    private final /* synthetic */ n.a aKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImageView imageView, GifView gifView, long j, n.a aVar) {
        this.aKk = imageView;
        this.aKl = gifView;
        this.aKm = j;
        this.aKn = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aKk.setVisibility(8);
        this.aKl.release();
        if (System.currentTimeMillis() - this.aKm > 3000) {
            com.baidu.tbadk.core.sharedPref.b.tQ().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.tQ().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aKn != null) {
            this.aKn.onCompleted();
        }
    }
}
