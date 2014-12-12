package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class az implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ an ccc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(an anVar) {
        this.ccc = anVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        this.ccc.eE(false);
        this.ccc.z(0.0f);
    }
}
