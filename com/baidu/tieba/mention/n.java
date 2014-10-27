package com.baidu.tieba.mention;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
/* loaded from: classes.dex */
class n {
    TextView bnv;
    ProgressBar mProgress;

    private n() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(n nVar) {
        this();
    }

    public void Q(View view) {
        this.bnv = (TextView) view.findViewById(com.baidu.tieba.v.pb_more_text);
        this.mProgress = (ProgressBar) view.findViewById(com.baidu.tieba.v.progress);
    }
}
