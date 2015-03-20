package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.ae;
/* loaded from: classes.dex */
class b implements ae {
    final /* synthetic */ TopRecActivity bxJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.bxJ = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        j jVar;
        jVar = this.bxJ.bxB;
        jVar.LoadData();
    }
}
