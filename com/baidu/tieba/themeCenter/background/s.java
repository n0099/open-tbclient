package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.y;
/* loaded from: classes.dex */
class s implements y.a {
    final /* synthetic */ BackgroundPreviewActivity dMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dMC = backgroundPreviewActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.y.a
    public void a(int i, String str, DressItemData dressItemData) {
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        BackgroundPreviewActivity backgroundPreviewActivity = this.dMC;
        aaVar = this.dMC.dMz;
        backgroundPreviewActivity.hideLoadingView(aaVar.getRootView());
        if (i == 0) {
            aaVar2 = this.dMC.dMz;
            aaVar2.e(dressItemData);
            return;
        }
        this.dMC.showToast(str);
        aaVar3 = this.dMC.dMz;
        aaVar3.Mr();
    }
}
