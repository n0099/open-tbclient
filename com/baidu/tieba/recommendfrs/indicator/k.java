package com.baidu.tieba.recommendfrs.indicator;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.lib.h.d {
    final /* synthetic */ j eaF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.eaF = jVar;
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
        textView = this.eaF.cIQ;
        if (textView != null) {
            animation2 = this.eaF.cIS;
            if (animation == animation2) {
                textView4 = this.eaF.cIQ;
                textView4.setVisibility(0);
                textView5 = this.eaF.cIQ;
                textView5.setClickable(true);
                return;
            }
            animation3 = this.eaF.cIT;
            if (animation == animation3) {
                textView2 = this.eaF.cIQ;
                textView2.setVisibility(8);
                textView3 = this.eaF.cIQ;
                textView3.setClickable(false);
            }
        }
    }
}
