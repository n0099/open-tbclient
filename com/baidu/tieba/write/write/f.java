package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class f implements NoNetworkView.a {
    final /* synthetic */ AtListActivity gjY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AtListActivity atListActivity) {
        this.gjY = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        if (!z) {
            return;
        }
        this.gjY.sv(null);
    }
}
