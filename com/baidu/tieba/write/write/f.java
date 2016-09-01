package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class f implements NoNetworkView.a {
    final /* synthetic */ AtListActivity gdO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AtListActivity atListActivity) {
        this.gdO = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aH(boolean z) {
        if (!z) {
            return;
        }
        this.gdO.ss(null);
    }
}
