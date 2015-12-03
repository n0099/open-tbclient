package com.baidu.tieba.themeCenter.background;

import com.baidu.tbadk.core.view.q;
/* loaded from: classes.dex */
class m implements q.a {
    final /* synthetic */ BackgroundListActivity dEK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BackgroundListActivity backgroundListActivity) {
        this.dEK = backgroundListActivity;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        o oVar;
        o oVar2;
        oVar = this.dEK.dEH;
        if (oVar != null) {
            oVar2 = this.dEK.dEH;
            oVar2.LoadData();
        }
    }
}
