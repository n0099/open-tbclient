package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class b implements BdListView.e {
    final /* synthetic */ AllThemeListActivity dNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AllThemeListActivity allThemeListActivity) {
        this.dNJ = allThemeListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        d dVar;
        d dVar2;
        dVar = this.dNJ.dNF;
        if (dVar != null) {
            dVar2 = this.dNJ.dNF;
            dVar2.aHM();
        }
    }
}
