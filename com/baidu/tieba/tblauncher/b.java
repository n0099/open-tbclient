package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.view.a {
    final /* synthetic */ GuideActivity caM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GuideActivity guideActivity) {
        this.caM = guideActivity;
    }

    @Override // com.baidu.tbadk.core.view.a
    public void cb(int i) {
        BaseViewPager baseViewPager;
        String str;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.caM.caC;
            if (baseViewPager != null) {
                baseViewPager2 = this.caM.caC;
                baseViewPager2.setOnScrollOutListener(null);
            }
            str = this.caM.cay;
            if (!str.equals(GuildActivityConfig.FROM_ABOUT_PAGE)) {
                this.caM.rq();
            }
            CompatibleUtile.setAnim(this.caM.getPageContext().getPageActivity(), 0, com.baidu.tieba.q.left);
            this.caM.closeActivity();
        }
    }
}
