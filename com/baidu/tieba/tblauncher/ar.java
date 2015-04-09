package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements SlidingMenu.OnAboveViewScrollListener {
    final /* synthetic */ ai csd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ai aiVar) {
        this.csd = aiVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnAboveViewScrollListener
    public void onPageScrolled(int i, float f, int i2) {
        SlidingMenu slidingMenu;
        ai aiVar = this.csd;
        slidingMenu = this.csd.aNR;
        aiVar.x(1.0f - slidingMenu.getPercentOpen());
    }
}
