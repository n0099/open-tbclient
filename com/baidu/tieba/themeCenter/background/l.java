package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class l implements BdListView.e {
    final /* synthetic */ BackgroundListActivity dMn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BackgroundListActivity backgroundListActivity) {
        this.dMn = backgroundListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        o oVar;
        o oVar2;
        oVar = this.dMn.dMk;
        if (oVar != null) {
            oVar2 = this.dMn.dMk;
            oVar2.aHG();
        }
    }
}
