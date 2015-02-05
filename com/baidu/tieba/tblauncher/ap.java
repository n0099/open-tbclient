package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements SlidingMenu.OnAboveViewScrollListener {
    final /* synthetic */ ai cdv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ai aiVar) {
        this.cdv = aiVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnAboveViewScrollListener
    public void onPageScrolled(int i, float f, int i2) {
        SlidingMenu slidingMenu;
        ai aiVar = this.cdv;
        slidingMenu = this.cdv.aFD;
        aiVar.y(1.0f - slidingMenu.getPercentOpen());
    }
}
