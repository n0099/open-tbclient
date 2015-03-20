package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class au implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ ai crN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ai aiVar) {
        this.crN = aiVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        this.crN.eW(false);
        this.crN.x(0.0f);
    }
}
