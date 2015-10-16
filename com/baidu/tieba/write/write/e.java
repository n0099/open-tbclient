package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class e implements NoNetworkView.a {
    final /* synthetic */ AtListActivity doy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AtListActivity atListActivity) {
        this.doy = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        if (!z) {
            return;
        }
        this.doy.mu(null);
    }
}
