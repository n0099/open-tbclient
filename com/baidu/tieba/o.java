package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class o implements GifView.a {
    private final /* synthetic */ ImageView aLi;
    private final /* synthetic */ GifView aLj;
    private final /* synthetic */ long aLk;
    private final /* synthetic */ n.a aLl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImageView imageView, GifView gifView, long j, n.a aVar) {
        this.aLi = imageView;
        this.aLj = gifView;
        this.aLk = j;
        this.aLl = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aLi.setVisibility(8);
        this.aLj.release();
        if (System.currentTimeMillis() - this.aLk > 3000) {
            com.baidu.tbadk.core.sharedPref.b.tW().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.tW().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aLl != null) {
            this.aLl.onCompleted();
        }
    }
}
