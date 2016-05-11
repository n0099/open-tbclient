package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class f implements NoNetworkView.a {
    final /* synthetic */ AtListActivity fcq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AtListActivity atListActivity) {
        this.fcq = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aF(boolean z) {
        if (!z) {
            return;
        }
        this.fcq.pm(null);
    }
}
