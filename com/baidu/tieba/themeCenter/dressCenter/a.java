package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.tieba.themeCenter.dressCenter.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ DressupCenterActivity dfI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DressupCenterActivity dressupCenterActivity) {
        this.dfI = dressupCenterActivity;
    }

    @Override // com.baidu.tieba.themeCenter.dressCenter.d.a
    public void a(int i, String str, List<b> list, k kVar, List<j> list2) {
        f fVar;
        f fVar2;
        f fVar3;
        DressupCenterActivity dressupCenterActivity = this.dfI;
        fVar = this.dfI.dfF;
        dressupCenterActivity.hideLoadingView(fVar.getRootView());
        if (i == 0) {
            fVar2 = this.dfI.dfF;
            fVar2.a(list, kVar, list2);
            return;
        }
        this.dfI.showToast(str);
        fVar3 = this.dfI.dfF;
        fVar3.Kr();
    }
}
