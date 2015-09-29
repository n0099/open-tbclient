package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.y;
/* loaded from: classes.dex */
class s implements y.a {
    final /* synthetic */ BackgroundPreviewActivity dfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dfo = backgroundPreviewActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.y.a
    public void a(int i, String str, DressItemData dressItemData) {
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        BackgroundPreviewActivity backgroundPreviewActivity = this.dfo;
        aaVar = this.dfo.dfl;
        backgroundPreviewActivity.hideLoadingView(aaVar.getRootView());
        if (i == 0) {
            aaVar2 = this.dfo.dfl;
            aaVar2.d(dressItemData);
            return;
        }
        this.dfo.showToast(str);
        aaVar3 = this.dfo.dfl;
        aaVar3.Kr();
    }
}
