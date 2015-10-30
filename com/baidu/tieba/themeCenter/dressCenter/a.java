package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.tieba.themeCenter.dressCenter.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ DressupCenterActivity dgi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DressupCenterActivity dressupCenterActivity) {
        this.dgi = dressupCenterActivity;
    }

    @Override // com.baidu.tieba.themeCenter.dressCenter.d.a
    public void a(int i, String str, List<b> list, k kVar, List<j> list2) {
        f fVar;
        f fVar2;
        f fVar3;
        DressupCenterActivity dressupCenterActivity = this.dgi;
        fVar = this.dgi.dgf;
        dressupCenterActivity.hideLoadingView(fVar.getRootView());
        if (i == 0) {
            fVar2 = this.dgi.dgf;
            fVar2.a(list, kVar, list2);
            return;
        }
        this.dgi.showToast(str);
        fVar3 = this.dgi.dgf;
        fVar3.Kn();
    }
}
