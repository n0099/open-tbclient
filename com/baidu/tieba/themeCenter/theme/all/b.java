package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class b implements BdListView.e {
    final /* synthetic */ AllThemeListActivity dfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AllThemeListActivity allThemeListActivity) {
        this.dfT = allThemeListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        d dVar;
        d dVar2;
        dVar = this.dfT.dfP;
        if (dVar != null) {
            dVar2 = this.dfT.dfP;
            dVar2.azr();
        }
    }
}
