package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class t implements GifView.a {
    private final /* synthetic */ ImageView aQH;
    private final /* synthetic */ GifView aQI;
    private final /* synthetic */ long aQJ;
    private final /* synthetic */ s.a aQK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageView imageView, GifView gifView, long j, s.a aVar) {
        this.aQH = imageView;
        this.aQI = gifView;
        this.aQJ = j;
        this.aQK = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aQH.setVisibility(8);
        this.aQI.release();
        if (System.currentTimeMillis() - this.aQJ > 3000) {
            com.baidu.tbadk.core.sharedPref.b.tX().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.tX().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aQK != null) {
            this.aQK.onCompleted();
        }
    }
}
