package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements SlidingMenu.OnAboveViewScrollListener {
    final /* synthetic */ ao dcY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ao aoVar) {
        this.dcY = aoVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnAboveViewScrollListener
    public void onPageScrolled(int i, float f, int i2) {
        SlidingMenu slidingMenu;
        ao aoVar = this.dcY;
        slidingMenu = this.dcY.bbO;
        aoVar.z(1.0f - slidingMenu.getPercentOpen());
    }
}
