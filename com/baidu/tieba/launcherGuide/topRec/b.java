package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class b implements p.a {
    final /* synthetic */ TopRecActivity bSK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.bSK = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        h hVar;
        hVar = this.bSK.bSC;
        hVar.LoadData();
    }
}
