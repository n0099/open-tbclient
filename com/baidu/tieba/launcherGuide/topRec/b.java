package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.ae;
/* loaded from: classes.dex */
class b implements ae {
    final /* synthetic */ TopRecActivity bxZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.bxZ = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        j jVar;
        jVar = this.bxZ.bxR;
        jVar.LoadData();
    }
}
