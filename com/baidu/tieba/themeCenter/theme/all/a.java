package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ AllThemeListActivity dNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AllThemeListActivity allThemeListActivity) {
        this.dNJ = allThemeListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.theme.top.d.a
    public void a(int i, String str, k kVar, List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        h hVar;
        h hVar2;
        d dVar;
        AllThemeListActivity allThemeListActivity = this.dNJ;
        hVar = this.dNJ.dNG;
        allThemeListActivity.hideLoadingView(hVar.getRootView());
        hVar2 = this.dNJ.dNG;
        dVar = this.dNJ.dNF;
        hVar2.a(kVar, list, dVar.aBV());
        if (i != 0) {
            this.dNJ.showToast(str);
        }
    }
}
