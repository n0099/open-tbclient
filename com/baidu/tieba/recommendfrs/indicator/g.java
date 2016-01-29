package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class g implements NoNetworkView.a {
    final /* synthetic */ ScrollFragmentTabHost dFt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dFt = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        a aVar;
        if (z) {
            aVar = this.dFt.dFm;
            aVar.hp(true);
        }
    }
}
