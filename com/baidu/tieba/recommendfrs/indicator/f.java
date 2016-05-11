package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ ScrollFragmentTabHost eaC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eaC = scrollFragmentTabHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eaC.aoi()) {
            this.eaC.aok();
            view.setContentDescription("展开");
            return;
        }
        this.eaC.aoj();
        TiebaStatic.log("c10510");
        view.setContentDescription("折叠");
    }
}
