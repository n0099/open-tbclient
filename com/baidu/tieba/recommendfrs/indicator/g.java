package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class g implements NoNetworkView.a {
    final /* synthetic */ ScrollFragmentTabHost dXs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dXs = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        a aVar;
        if (z) {
            aVar = this.dXs.dXl;
            aVar.ic(true);
        }
    }
}
