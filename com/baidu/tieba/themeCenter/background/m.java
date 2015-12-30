package com.baidu.tieba.themeCenter.background;

import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class m implements r.a {
    final /* synthetic */ BackgroundListActivity dMn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BackgroundListActivity backgroundListActivity) {
        this.dMn = backgroundListActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        o oVar;
        o oVar2;
        oVar = this.dMn.dMk;
        if (oVar != null) {
            oVar2 = this.dMn.dMk;
            oVar2.LoadData();
        }
    }
}
