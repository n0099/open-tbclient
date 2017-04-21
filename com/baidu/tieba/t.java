package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class t implements GifView.a {
    private final /* synthetic */ ImageView aQo;
    private final /* synthetic */ GifView aQp;
    private final /* synthetic */ long aQq;
    private final /* synthetic */ s.a aQr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageView imageView, GifView gifView, long j, s.a aVar) {
        this.aQo = imageView;
        this.aQp = gifView;
        this.aQq = j;
        this.aQr = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aQo.setVisibility(8);
        this.aQp.release();
        if (System.currentTimeMillis() - this.aQq > 3000) {
            com.baidu.tbadk.core.sharedPref.b.uL().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.uL().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aQr != null) {
            this.aQr.onCompleted();
        }
    }
}
