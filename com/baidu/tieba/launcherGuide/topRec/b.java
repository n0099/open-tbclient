package com.baidu.tieba.launcherGuide.topRec;

import com.baidu.tbadk.core.view.q;
/* loaded from: classes.dex */
class b implements q.a {
    final /* synthetic */ TopRecActivity cjE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopRecActivity topRecActivity) {
        this.cjE = topRecActivity;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        h hVar;
        hVar = this.cjE.cjw;
        hVar.LoadData();
    }
}
