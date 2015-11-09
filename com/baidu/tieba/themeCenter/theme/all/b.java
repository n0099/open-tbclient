package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class b implements BdListView.e {
    final /* synthetic */ AllThemeListActivity dhZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AllThemeListActivity allThemeListActivity) {
        this.dhZ = allThemeListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        d dVar;
        d dVar2;
        dVar = this.dhZ.dhV;
        if (dVar != null) {
            dVar2 = this.dhZ.dhV;
            dVar2.aAn();
        }
    }
}
