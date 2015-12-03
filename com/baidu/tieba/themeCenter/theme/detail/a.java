package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.tieba.themeCenter.theme.detail.e;
/* loaded from: classes.dex */
class a implements e.a {
    final /* synthetic */ SkinDetailActivity dGJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SkinDetailActivity skinDetailActivity) {
        this.dGJ = skinDetailActivity;
    }

    @Override // com.baidu.tieba.themeCenter.theme.detail.e.a
    public void a(int i, String str, com.baidu.tieba.themeCenter.b bVar) {
        g gVar;
        com.baidu.tieba.themeCenter.b bVar2;
        g gVar2;
        com.baidu.tieba.themeCenter.b bVar3;
        com.baidu.tieba.themeCenter.b bVar4;
        int i2;
        com.baidu.tieba.themeCenter.b bVar5;
        int i3;
        com.baidu.tieba.themeCenter.b bVar6;
        String str2;
        com.baidu.tieba.themeCenter.b bVar7;
        String str3;
        g gVar3;
        SkinDetailActivity skinDetailActivity = this.dGJ;
        gVar = this.dGJ.dGD;
        skinDetailActivity.hideLoadingView(gVar.getRootView());
        if (i == 0) {
            this.dGJ.mSkinData = bVar;
            bVar2 = this.dGJ.mSkinData;
            if (bVar2 != null) {
                bVar4 = this.dGJ.mSkinData;
                i2 = this.dGJ.dGE;
                bVar4.setId(i2);
                bVar5 = this.dGJ.mSkinData;
                i3 = this.dGJ.mSkinType;
                bVar5.mP(i3);
                bVar6 = this.dGJ.mSkinData;
                str2 = this.dGJ.dGF;
                bVar6.mN(str2);
                bVar7 = this.dGJ.mSkinData;
                str3 = this.dGJ.dGG;
                bVar7.mP(str3);
            }
            gVar2 = this.dGJ.dGD;
            bVar3 = this.dGJ.mSkinData;
            gVar2.i(bVar3);
            return;
        }
        this.dGJ.showToast(str);
        gVar3 = this.dGJ.dGD;
        gVar3.LY();
    }
}
