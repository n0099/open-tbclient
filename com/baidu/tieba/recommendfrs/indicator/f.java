package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ ScrollFragmentTabHost dFt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dFt = scrollFragmentTabHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dFt.aFI()) {
            this.dFt.aFK();
            return;
        }
        this.dFt.aFJ();
        TiebaStatic.log("c10510");
    }
}
