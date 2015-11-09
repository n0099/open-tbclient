package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.tieba.themeCenter.theme.detail.d;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ SkinDetailActivity diy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SkinDetailActivity skinDetailActivity) {
        this.diy = skinDetailActivity;
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
        SkinDetailActivity skinDetailActivity = this.diy;
        fVar = this.diy.dit;
        skinDetailActivity.hideLoadingView(fVar.getRootView());
        if (i == 0) {
            this.diy.mSkinData = bVar;
            bVar2 = this.diy.mSkinData;
            if (bVar2 != null) {
                bVar4 = this.diy.mSkinData;
                i2 = this.diy.diu;
                bVar4.setId(i2);
                bVar5 = this.diy.mSkinData;
                i3 = this.diy.mSkinType;
                bVar5.lF(i3);
                bVar6 = this.diy.mSkinData;
                str2 = this.diy.div;
                bVar6.lW(str2);
                bVar7 = this.diy.mSkinData;
                str3 = this.diy.diw;
                bVar7.lY(str3);
            }
            fVar2 = this.diy.dit;
            bVar3 = this.diy.mSkinData;
            fVar2.g(bVar3);
            return;
        }
        this.diy.showToast(str);
        fVar3 = this.diy.dit;
        fVar3.KD();
    }
}
