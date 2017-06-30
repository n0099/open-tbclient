package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class t implements GifView.a {
    private final /* synthetic */ ImageView aSb;
    private final /* synthetic */ GifView aSc;
    private final /* synthetic */ long aSd;
    private final /* synthetic */ s.a aSe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageView imageView, GifView gifView, long j, s.a aVar) {
        this.aSb = imageView;
        this.aSc = gifView;
        this.aSd = j;
        this.aSe = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aSb.setVisibility(8);
        this.aSc.release();
        if (System.currentTimeMillis() - this.aSd > 3000) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aSe != null) {
            this.aSe.onCompleted();
        }
    }
}
