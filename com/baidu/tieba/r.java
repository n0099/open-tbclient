package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
class r implements GifView.a {
    private final /* synthetic */ ImageView aIp;
    private final /* synthetic */ GifView aIq;
    private final /* synthetic */ long aIr;
    private final /* synthetic */ q.a aIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ImageView imageView, GifView gifView, long j, q.a aVar) {
        this.aIp = imageView;
        this.aIq = gifView;
        this.aIr = j;
        this.aIs = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aIp.setVisibility(8);
        this.aIq.release();
        if (System.currentTimeMillis() - this.aIr > 3000) {
            com.baidu.tbadk.core.sharedPref.b.sN().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.sN().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aIs != null) {
            this.aIs.onCompleted();
        }
    }
}
