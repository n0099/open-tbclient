package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* loaded from: classes.dex */
class b implements d.a {
    final /* synthetic */ TopThemeListActivity dhw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TopThemeListActivity topThemeListActivity) {
        this.dhw = topThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.theme.top.d.a
    public void a(int i, String str, k kVar, List<a> list) {
        h hVar;
        h hVar2;
        h hVar3;
        TopThemeListActivity topThemeListActivity = this.dhw;
        hVar = this.dhw.dhv;
        topThemeListActivity.hideLoadingView(hVar.getRootView());
        if (i == 0) {
            hVar2 = this.dhw.dhv;
            hVar2.a(kVar, list);
            return;
        }
        this.dhw.showToast(str);
        hVar3 = this.dhw.dhv;
        hVar3.Kr();
    }
}
