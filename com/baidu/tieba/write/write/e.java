package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class e implements NoNetworkView.a {
    final /* synthetic */ AtListActivity erI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AtListActivity atListActivity) {
        this.erI = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        if (!z) {
            return;
        }
        this.erI.nJ(null);
    }
}
