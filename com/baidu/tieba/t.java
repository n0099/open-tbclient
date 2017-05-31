package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class t implements GifView.a {
    private final /* synthetic */ ImageView aQI;
    private final /* synthetic */ GifView aQJ;
    private final /* synthetic */ long aQK;
    private final /* synthetic */ s.a aQL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageView imageView, GifView gifView, long j, s.a aVar) {
        this.aQI = imageView;
        this.aQJ = gifView;
        this.aQK = j;
        this.aQL = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aQI.setVisibility(8);
        this.aQJ.release();
        if (System.currentTimeMillis() - this.aQK > 3000) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aQL != null) {
            this.aQL.onCompleted();
        }
    }
}
