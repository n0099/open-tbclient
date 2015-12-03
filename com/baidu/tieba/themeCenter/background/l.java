package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class l implements BdListView.e {
    final /* synthetic */ BackgroundListActivity dEK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BackgroundListActivity backgroundListActivity) {
        this.dEK = backgroundListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        o oVar;
        o oVar2;
        oVar = this.dEK.dEH;
        if (oVar != null) {
            oVar2 = this.dEK.dEH;
            oVar2.aFr();
        }
    }
}
