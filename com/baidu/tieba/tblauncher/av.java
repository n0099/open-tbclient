package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements SlidingMenu.OnAboveViewScrollListener {
    final /* synthetic */ ai cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ai aiVar) {
        this.cMQ = aiVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnAboveViewScrollListener
    public void onPageScrolled(int i, float f, int i2) {
        SlidingMenu slidingMenu;
        ai aiVar = this.cMQ;
        slidingMenu = this.cMQ.bbA;
        aiVar.y(1.0f - slidingMenu.getPercentOpen());
    }
}
