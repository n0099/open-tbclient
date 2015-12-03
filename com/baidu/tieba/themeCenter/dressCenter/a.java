package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.tieba.themeCenter.dressCenter.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ DressupCenterActivity dFW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DressupCenterActivity dressupCenterActivity) {
        this.dFW = dressupCenterActivity;
    }

    @Override // com.baidu.tieba.themeCenter.dressCenter.d.a
    public void a(int i, String str, List<b> list, k kVar, List<j> list2) {
        f fVar;
        f fVar2;
        d dVar;
        f fVar3;
        DressupCenterActivity dressupCenterActivity = this.dFW;
        fVar = this.dFW.dFT;
        dressupCenterActivity.hideLoadingView(fVar.getRootView());
        if (i == 0) {
            fVar2 = this.dFW.dFT;
            dVar = this.dFW.dFU;
            fVar2.a(list, kVar, list2, dVar.azO());
            return;
        }
        this.dFW.showToast(str);
        fVar3 = this.dFW.dFT;
        fVar3.LY();
    }
}
