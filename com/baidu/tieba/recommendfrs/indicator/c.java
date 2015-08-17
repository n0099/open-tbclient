package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ ScrollFragmentTabHost ctr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ctr = scrollFragmentTabHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ctr.ajS()) {
            this.ctr.ajU();
        } else {
            this.ctr.ajT();
        }
    }
}
