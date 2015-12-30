package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.tieba.themeCenter.theme.detail.e;
/* loaded from: classes.dex */
class a implements e.a {
    final /* synthetic */ SkinDetailActivity dOk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SkinDetailActivity skinDetailActivity) {
        this.dOk = skinDetailActivity;
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
        SkinDetailActivity skinDetailActivity = this.dOk;
        gVar = this.dOk.dOe;
        skinDetailActivity.hideLoadingView(gVar.getRootView());
        if (i == 0) {
            this.dOk.mSkinData = bVar;
            bVar2 = this.dOk.mSkinData;
            if (bVar2 != null) {
                bVar4 = this.dOk.mSkinData;
                i2 = this.dOk.dOf;
                bVar4.setId(i2);
                bVar5 = this.dOk.mSkinData;
                i3 = this.dOk.mSkinType;
                bVar5.nr(i3);
                bVar6 = this.dOk.mSkinData;
                str2 = this.dOk.dOg;
                bVar6.mK(str2);
                bVar7 = this.dOk.mSkinData;
                str3 = this.dOk.dOh;
                bVar7.mM(str3);
            }
            gVar2 = this.dOk.dOe;
            bVar3 = this.dOk.mSkinData;
            gVar2.i(bVar3);
            return;
        }
        this.dOk.showToast(str);
        gVar3 = this.dOk.dOe;
        gVar3.Mr();
    }
}
