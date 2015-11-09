package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class l implements BdListView.e {
    final /* synthetic */ BackgroundListActivity dhh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BackgroundListActivity backgroundListActivity) {
        this.dhh = backgroundListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        o oVar;
        r rVar;
        o oVar2;
        oVar = this.dhh.dhe;
        if (oVar != null) {
            BackgroundListActivity backgroundListActivity = this.dhh;
            rVar = this.dhh.dhf;
            backgroundListActivity.showLoadingView(rVar.getRootView());
            oVar2 = this.dhh.dhe;
            oVar2.aAj();
        }
    }
}
