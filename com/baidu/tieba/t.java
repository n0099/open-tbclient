package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
class t implements GifView.a {
    private final /* synthetic */ ImageView aPW;
    private final /* synthetic */ GifView aPX;
    private final /* synthetic */ long aPY;
    private final /* synthetic */ s.a aPZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageView imageView, GifView gifView, long j, s.a aVar) {
        this.aPW = imageView;
        this.aPX = gifView;
        this.aPY = j;
        this.aPZ = aVar;
    }

    @Override // com.baidu.tbadk.gif.GifView.a
    public void onStop() {
        this.aPW.setVisibility(8);
        this.aPX.release();
        if (System.currentTimeMillis() - this.aPY > 3000) {
            com.baidu.tbadk.core.sharedPref.b.uo().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.uo().getInt("logo_animation_overtime_count", 0) + 1);
        }
        if (this.aPZ != null) {
            this.aPZ.onCompleted();
        }
    }
}
