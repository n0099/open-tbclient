package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class t implements GifView.a {
    private final /* synthetic */ ImageView aQm;
    private final /* synthetic */ GifView aQn;
    private final /* synthetic */ long aQo;
    private final /* synthetic */ s.a aQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageView imageView, GifView gifView, long j, s.a aVar) {
        this.aQm = imageView;
        this.aQn = gifView;
        this.aQo = j;
        this.aQp = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aQm.setVisibility(8);
        this.aQn.release();
        if (System.currentTimeMillis() - this.aQo > 3000) {
            com.baidu.tbadk.core.sharedPref.b.uL().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.uL().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aQp != null) {
            this.aQp.onCompleted();
        }
    }
}
