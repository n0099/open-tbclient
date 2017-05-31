package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class a implements BaseViewPager.a {
    final /* synthetic */ GuideActivity dsp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GuideActivity guideActivity) {
        this.dsp = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager.a
    public void cV(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.dsp.dsc;
            if (baseViewPager != null) {
                baseViewPager2 = this.dsp.dsc;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.dsp.baO;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.dsp.Kk();
            }
            CompatibleUtile.setAnim(this.dsp.getPageContext().getPageActivity(), 0, w.a.left);
            this.dsp.closeActivity();
        }
    }
}
