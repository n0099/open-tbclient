package com.baidu.tieba.recommendfrs.indicator;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.h.d {
    final /* synthetic */ e dpM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dpM = eVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        TextView textView;
        Animation animation2;
        Animation animation3;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        textView = this.dpM.dpH;
        if (textView != null) {
            animation2 = this.dpM.dpJ;
            if (animation == animation2) {
                textView4 = this.dpM.dpH;
                textView4.setVisibility(0);
                textView5 = this.dpM.dpH;
                textView5.setClickable(true);
                return;
            }
            animation3 = this.dpM.dpK;
            if (animation == animation3) {
                textView2 = this.dpM.dpH;
                textView2.setVisibility(8);
                textView3 = this.dpM.dpH;
                textView3.setClickable(false);
            }
        }
    }
}
