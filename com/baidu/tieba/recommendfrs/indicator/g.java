package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class g implements NoNetworkView.a {
    final /* synthetic */ ScrollFragmentTabHost eaC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eaC = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aF(boolean z) {
        a aVar;
        if (z) {
            aVar = this.eaC.eau;
            aVar.iR(true);
        }
    }
}
