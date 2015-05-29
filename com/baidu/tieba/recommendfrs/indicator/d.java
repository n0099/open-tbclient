package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final int TN;
    final /* synthetic */ ScrollFragmentTabWidget ccp;

    private d(ScrollFragmentTabWidget scrollFragmentTabWidget, int i) {
        this.ccp = scrollFragmentTabWidget;
        this.TN = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(ScrollFragmentTabWidget scrollFragmentTabWidget, int i, d dVar) {
        this(scrollFragmentTabWidget, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ScrollFragmentTabWidget.a(this.ccp).c(this.TN, true);
    }
}
