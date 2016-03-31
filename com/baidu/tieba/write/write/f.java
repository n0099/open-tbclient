package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class f implements NoNetworkView.a {
    final /* synthetic */ AtListActivity eLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AtListActivity atListActivity) {
        this.eLC = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        if (!z) {
            return;
        }
        this.eLC.oY(null);
    }
}
