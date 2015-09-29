package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* loaded from: classes.dex */
class b implements d.a {
    final /* synthetic */ TopThemeListActivity dgW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopThemeListActivity topThemeListActivity) {
        this.dgW = topThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.theme.top.d.a
    public void a(int i, String str, k kVar, List<a> list) {
        h hVar;
        h hVar2;
        h hVar3;
        TopThemeListActivity topThemeListActivity = this.dgW;
        hVar = this.dgW.dgV;
        topThemeListActivity.hideLoadingView(hVar.getRootView());
        if (i == 0) {
            hVar2 = this.dgW.dgV;
            hVar2.a(kVar, list);
            return;
        }
        this.dgW.showToast(str);
        hVar3 = this.dgW.dgV;
        hVar3.Kr();
    }
}
