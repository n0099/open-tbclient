package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ ScrollFragmentTabHost cKF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cKF = scrollFragmentTabHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cKF.aqY()) {
            this.cKF.ara();
        } else {
            this.cKF.aqZ();
        }
    }
}
