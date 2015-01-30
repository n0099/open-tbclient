package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements SlidingMenu.OnAboveViewScrollListener {
    final /* synthetic */ ai cdw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ai aiVar) {
        this.cdw = aiVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnAboveViewScrollListener
    public void onPageScrolled(int i, float f, int i2) {
        SlidingMenu slidingMenu;
        ai aiVar = this.cdw;
        slidingMenu = this.cdw.aFG;
        aiVar.y(1.0f - slidingMenu.getPercentOpen());
    }
}
