package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* loaded from: classes.dex */
class b implements d.a {
    final /* synthetic */ TopThemeListActivity dON;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopThemeListActivity topThemeListActivity) {
        this.dON = topThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.theme.top.d.a
    public void a(int i, String str, k kVar, List<a> list) {
        h hVar;
        h hVar2;
        d dVar;
        h hVar3;
        TopThemeListActivity topThemeListActivity = this.dON;
        hVar = this.dON.dOM;
        topThemeListActivity.hideLoadingView(hVar.getRootView());
        if (i == 0) {
            hVar2 = this.dON.dOM;
            dVar = this.dON.dOL;
            hVar2.a(kVar, list, dVar.aBV());
            return;
        }
        this.dON.showToast(str);
        hVar3 = this.dON.dOM;
        hVar3.Mr();
    }
}
