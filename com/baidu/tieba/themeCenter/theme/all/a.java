package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ AllThemeListActivity dGi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AllThemeListActivity allThemeListActivity) {
        this.dGi = allThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.theme.top.d.a
    public void a(int i, String str, k kVar, List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        h hVar;
        h hVar2;
        d dVar;
        AllThemeListActivity allThemeListActivity = this.dGi;
        hVar = this.dGi.dGf;
        allThemeListActivity.hideLoadingView(hVar.getRootView());
        hVar2 = this.dGi.dGf;
        dVar = this.dGi.dGe;
        hVar2.a(kVar, list, dVar.azO());
        if (i != 0) {
            this.dGi.showToast(str);
        }
    }
}
