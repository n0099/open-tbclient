package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.tieba.themeCenter.theme.detail.d;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ SkinDetailActivity dgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SkinDetailActivity skinDetailActivity) {
        this.dgS = skinDetailActivity;
    }

    @Override // com.baidu.tieba.themeCenter.theme.detail.d.a
    public void a(int i, String str, com.baidu.tieba.themeCenter.b bVar) {
        f fVar;
        com.baidu.tieba.themeCenter.b bVar2;
        f fVar2;
        com.baidu.tieba.themeCenter.b bVar3;
        com.baidu.tieba.themeCenter.b bVar4;
        int i2;
        com.baidu.tieba.themeCenter.b bVar5;
        int i3;
        com.baidu.tieba.themeCenter.b bVar6;
        String str2;
        com.baidu.tieba.themeCenter.b bVar7;
        String str3;
        f fVar3;
        SkinDetailActivity skinDetailActivity = this.dgS;
        fVar = this.dgS.dgN;
        skinDetailActivity.hideLoadingView(fVar.getRootView());
        if (i == 0) {
            this.dgS.mSkinData = bVar;
            bVar2 = this.dgS.mSkinData;
            if (bVar2 != null) {
                bVar4 = this.dgS.mSkinData;
                i2 = this.dgS.dgO;
                bVar4.setId(i2);
                bVar5 = this.dgS.mSkinData;
                i3 = this.dgS.mSkinType;
                bVar5.lr(i3);
                bVar6 = this.dgS.mSkinData;
                str2 = this.dgS.dgP;
                bVar6.lS(str2);
                bVar7 = this.dgS.mSkinData;
                str3 = this.dgS.dgQ;
                bVar7.lU(str3);
            }
            fVar2 = this.dgS.dgN;
            bVar3 = this.dgS.mSkinData;
            fVar2.g(bVar3);
            return;
        }
        this.dgS.showToast(str);
        fVar3 = this.dgS.dgN;
        fVar3.Kr();
    }
}
