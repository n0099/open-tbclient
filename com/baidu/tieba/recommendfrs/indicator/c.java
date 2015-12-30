package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ ScrollFragmentTabHost dpF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dpF = scrollFragmentTabHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dpF.ayB()) {
            this.dpF.ayD();
            return;
        }
        this.dpF.ayC();
        TiebaStatic.log("c10510");
    }
}
