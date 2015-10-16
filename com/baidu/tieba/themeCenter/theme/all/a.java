package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ AllThemeListActivity dgt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AllThemeListActivity allThemeListActivity) {
        this.dgt = allThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.theme.top.d.a
    public void a(int i, String str, k kVar, List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        h hVar;
        h hVar2;
        AllThemeListActivity allThemeListActivity = this.dgt;
        hVar = this.dgt.dgq;
        allThemeListActivity.hideLoadingView(hVar.getRootView());
        hVar2 = this.dgt.dgq;
        hVar2.a(kVar, list);
        if (i != 0) {
            this.dgt.showToast(str);
        }
    }
}
