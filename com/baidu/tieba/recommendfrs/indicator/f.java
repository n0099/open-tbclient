package com.baidu.tieba.recommendfrs.indicator;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.g.d {
    final /* synthetic */ e cJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cJq = eVar;
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
        textView = this.cJq.cJl;
        if (textView != null) {
            animation2 = this.cJq.cJn;
            if (animation == animation2) {
                textView4 = this.cJq.cJl;
                textView4.setVisibility(0);
                textView5 = this.cJq.cJl;
                textView5.setClickable(true);
                return;
            }
            animation3 = this.cJq.cJo;
            if (animation == animation3) {
                textView2 = this.cJq.cJl;
                textView2.setVisibility(8);
                textView3 = this.cJq.cJl;
                textView3.setClickable(false);
            }
        }
    }
}
