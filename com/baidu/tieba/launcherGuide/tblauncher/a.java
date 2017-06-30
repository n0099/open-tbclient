package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity dBc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.dBc = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cX(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.dBc.dAP;
            if (baseViewPager != null) {
                baseViewPager2 = this.dBc.dAP;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.dBc.bcT;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.dBc.KI();
            }
            CompatibleUtile.setAnim(this.dBc.getPageContext().getPageActivity(), 0, w.a.left);
            this.dBc.closeActivity();
        }
    }
}
