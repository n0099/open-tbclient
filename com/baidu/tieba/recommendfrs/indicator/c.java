package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ ScrollFragmentTabHost cJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cJj = scrollFragmentTabHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cJj.aqw()) {
            this.cJj.aqy();
        } else {
            this.cJj.aqx();
        }
    }
}
