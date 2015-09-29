package com.baidu.tieba.recommendfrs.indicator;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.g.d {
    final /* synthetic */ e cIR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cIR = eVar;
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
        textView = this.cIR.cIM;
        if (textView != null) {
            animation2 = this.cIR.cIO;
            if (animation == animation2) {
                textView4 = this.cIR.cIM;
                textView4.setVisibility(0);
                textView5 = this.cIR.cIM;
                textView5.setClickable(true);
                return;
            }
            animation3 = this.cIR.cIP;
            if (animation == animation3) {
                textView2 = this.cIR.cIM;
                textView2.setVisibility(8);
                textView3 = this.cIR.cIM;
                textView3.setClickable(false);
            }
        }
    }
}
