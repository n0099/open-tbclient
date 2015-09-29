package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class l implements BdListView.e {
    final /* synthetic */ BackgroundListActivity dfb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BackgroundListActivity backgroundListActivity) {
        this.dfb = backgroundListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        o oVar;
        r rVar;
        o oVar2;
        oVar = this.dfb.deY;
        if (oVar != null) {
            BackgroundListActivity backgroundListActivity = this.dfb;
            rVar = this.dfb.deZ;
            backgroundListActivity.showLoadingView(rVar.getRootView());
            oVar2 = this.dfb.deY;
            oVar2.azn();
        }
    }
}
