package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements SlidingMenu.OnAboveViewScrollListener {
    final /* synthetic */ ai crN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ai aiVar) {
        this.crN = aiVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnAboveViewScrollListener
    public void onPageScrolled(int i, float f, int i2) {
        SlidingMenu slidingMenu;
        ai aiVar = this.crN;
        slidingMenu = this.crN.aNA;
        aiVar.x(1.0f - slidingMenu.getPercentOpen());
    }
}
