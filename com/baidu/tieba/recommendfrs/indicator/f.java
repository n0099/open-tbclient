package com.baidu.tieba.recommendfrs.indicator;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.g.d {
    final /* synthetic */ e cBQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cBQ = eVar;
    }

    @Override // com.baidu.adp.lib.g.d
    public void b(Animation animation) {
        TextView textView;
        Animation animation2;
        Animation animation3;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        textView = this.cBQ.cBL;
        if (textView != null) {
            animation2 = this.cBQ.cBN;
            if (animation == animation2) {
                textView4 = this.cBQ.cBL;
                textView4.setVisibility(0);
                textView5 = this.cBQ.cBL;
                textView5.setClickable(true);
                return;
            }
            animation3 = this.cBQ.cBO;
            if (animation == animation3) {
                textView2 = this.cBQ.cBL;
                textView2.setVisibility(8);
                textView3 = this.cBQ.cBL;
                textView3.setClickable(false);
            }
        }
    }
}
