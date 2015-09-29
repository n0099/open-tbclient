package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.tieba.themeCenter.theme.detail.d;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ SkinDetailActivity dgs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SkinDetailActivity skinDetailActivity) {
        this.dgs = skinDetailActivity;
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
        SkinDetailActivity skinDetailActivity = this.dgs;
        fVar = this.dgs.dgn;
        skinDetailActivity.hideLoadingView(fVar.getRootView());
        if (i == 0) {
            this.dgs.mSkinData = bVar;
            bVar2 = this.dgs.mSkinData;
            if (bVar2 != null) {
                bVar4 = this.dgs.mSkinData;
                i2 = this.dgs.dgo;
                bVar4.setId(i2);
                bVar5 = this.dgs.mSkinData;
                i3 = this.dgs.mSkinType;
                bVar5.lp(i3);
                bVar6 = this.dgs.mSkinData;
                str2 = this.dgs.dgp;
                bVar6.lP(str2);
                bVar7 = this.dgs.mSkinData;
                str3 = this.dgs.dgq;
                bVar7.lR(str3);
            }
            fVar2 = this.dgs.dgn;
            bVar3 = this.dgs.mSkinData;
            fVar2.g(bVar3);
            return;
        }
        this.dgs.showToast(str);
        fVar3 = this.dgs.dgn;
        fVar3.Kr();
    }
}
