package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.tieba.themeCenter.dressCenter.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ DressupCenterActivity dNy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DressupCenterActivity dressupCenterActivity) {
        this.dNy = dressupCenterActivity;
    }

    @Override // com.baidu.tieba.themeCenter.dressCenter.d.a
    public void a(int i, String str, List<b> list, k kVar, List<j> list2) {
        f fVar;
        f fVar2;
        d dVar;
        f fVar3;
        DressupCenterActivity dressupCenterActivity = this.dNy;
        fVar = this.dNy.dNv;
        dressupCenterActivity.hideLoadingView(fVar.getRootView());
        if (i == 0) {
            fVar2 = this.dNy.dNv;
            dVar = this.dNy.dNw;
            fVar2.a(list, kVar, list2, dVar.aBV());
            return;
        }
        this.dNy.showToast(str);
        fVar3 = this.dNy.dNv;
        fVar3.Mr();
    }
}
