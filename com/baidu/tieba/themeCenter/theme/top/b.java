package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* loaded from: classes.dex */
class b implements d.a {
    final /* synthetic */ TopThemeListActivity dHm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopThemeListActivity topThemeListActivity) {
        this.dHm = topThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.theme.top.d.a
    public void a(int i, String str, k kVar, List<a> list) {
        h hVar;
        h hVar2;
        d dVar;
        h hVar3;
        TopThemeListActivity topThemeListActivity = this.dHm;
        hVar = this.dHm.dHl;
        topThemeListActivity.hideLoadingView(hVar.getRootView());
        if (i == 0) {
            hVar2 = this.dHm.dHl;
            dVar = this.dHm.dHk;
            hVar2.a(kVar, list, dVar.azO());
            return;
        }
        this.dHm.showToast(str);
        hVar3 = this.dHm.dHl;
        hVar3.LY();
    }
}
