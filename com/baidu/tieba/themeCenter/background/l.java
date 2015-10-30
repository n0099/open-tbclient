package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class l implements BdListView.e {
    final /* synthetic */ BackgroundListActivity dfB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BackgroundListActivity backgroundListActivity) {
        this.dfB = backgroundListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        o oVar;
        r rVar;
        o oVar2;
        oVar = this.dfB.dfy;
        if (oVar != null) {
            BackgroundListActivity backgroundListActivity = this.dfB;
            rVar = this.dfB.dfz;
            backgroundListActivity.showLoadingView(rVar.getRootView());
            oVar2 = this.dfB.dfy;
            oVar2.azt();
        }
    }
}
