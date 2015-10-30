package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.y;
/* loaded from: classes.dex */
class s implements y.a {
    final /* synthetic */ BackgroundPreviewActivity dfO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.dfO = backgroundPreviewActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.y.a
    public void a(int i, String str, DressItemData dressItemData) {
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        BackgroundPreviewActivity backgroundPreviewActivity = this.dfO;
        aaVar = this.dfO.dfL;
        backgroundPreviewActivity.hideLoadingView(aaVar.getRootView());
        if (i == 0) {
            aaVar2 = this.dfO.dfL;
            aaVar2.d(dressItemData);
            return;
        }
        this.dfO.showToast(str);
        aaVar3 = this.dfO.dfL;
        aaVar3.Kn();
    }
}
