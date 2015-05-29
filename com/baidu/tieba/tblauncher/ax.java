package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class ax implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ aj cwn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aj ajVar) {
        this.cwn = ajVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        this.cwn.fo(false);
        this.cwn.y(0.0f);
    }
}
