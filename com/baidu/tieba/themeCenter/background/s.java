package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.y;
/* loaded from: classes.dex */
class s implements y.a {
    final /* synthetic */ BackgroundPreviewActivity dFa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dFa = backgroundPreviewActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.y.a
    public void a(int i, String str, DressItemData dressItemData) {
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        BackgroundPreviewActivity backgroundPreviewActivity = this.dFa;
        aaVar = this.dFa.dEX;
        backgroundPreviewActivity.hideLoadingView(aaVar.getRootView());
        if (i == 0) {
            aaVar2 = this.dFa.dEX;
            aaVar2.e(dressItemData);
            return;
        }
        this.dFa.showToast(str);
        aaVar3 = this.dFa.dEX;
        aaVar3.LY();
    }
}
