package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ ScrollFragmentTabHost djb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.djb = scrollFragmentTabHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.djb.aww()) {
            this.djb.awy();
            return;
        }
        this.djb.awx();
        TiebaStatic.log("c10510");
    }
}
