package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
class r implements GifView.a {
    private final /* synthetic */ long aHA;
    private final /* synthetic */ q.a aHB;
    private final /* synthetic */ ImageView aHy;
    private final /* synthetic */ GifView aHz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ImageView imageView, GifView gifView, long j, q.a aVar) {
        this.aHy = imageView;
        this.aHz = gifView;
        this.aHA = j;
        this.aHB = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aHy.setVisibility(8);
        this.aHz.release();
        if (System.currentTimeMillis() - this.aHA > 3000) {
            com.baidu.tbadk.core.sharedPref.b.sO().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.sO().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aHB != null) {
            this.aHB.onCompleted();
        }
    }
}
