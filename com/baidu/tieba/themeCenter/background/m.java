package com.baidu.tieba.themeCenter.background;

import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class m implements p.a {
    final /* synthetic */ BackgroundListActivity dfb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BackgroundListActivity backgroundListActivity) {
        this.dfb = backgroundListActivity;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        o oVar;
        o oVar2;
        oVar = this.dfb.deY;
        if (oVar != null) {
            oVar2 = this.dfb.deY;
            oVar2.LoadData();
        }
    }
}
