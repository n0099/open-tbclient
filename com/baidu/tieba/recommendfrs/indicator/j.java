package com.baidu.tieba.recommendfrs.indicator;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.h.d {
    final /* synthetic */ i dFB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.dFB = iVar;
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
        textView = this.dFB.dFv;
        if (textView != null) {
            animation2 = this.dFB.dFy;
            if (animation == animation2) {
                textView4 = this.dFB.dFv;
                textView4.setVisibility(0);
                textView5 = this.dFB.dFv;
                textView5.setClickable(true);
                return;
            }
            animation3 = this.dFB.dFz;
            if (animation == animation3) {
                textView2 = this.dFB.dFv;
                textView2.setVisibility(8);
                textView3 = this.dFB.dFv;
                textView3.setClickable(false);
            }
        }
    }
}
