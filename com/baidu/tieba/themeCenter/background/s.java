package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.y;
/* loaded from: classes.dex */
class s implements y.a {
    final /* synthetic */ BackgroundPreviewActivity dhu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dhu = backgroundPreviewActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.y.a
    public void a(int i, String str, DressItemData dressItemData) {
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        BackgroundPreviewActivity backgroundPreviewActivity = this.dhu;
        aaVar = this.dhu.dhr;
        backgroundPreviewActivity.hideLoadingView(aaVar.getRootView());
        if (i == 0) {
            aaVar2 = this.dhu.dhr;
            aaVar2.d(dressItemData);
            return;
        }
        this.dhu.showToast(str);
        aaVar3 = this.dhu.dhr;
        aaVar3.KD();
    }
}
