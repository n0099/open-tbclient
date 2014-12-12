package com.baidu.tieba.tblauncher;

import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class ba implements SlidingMenu.OnClosedListener {
    final /* synthetic */ an ccc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(an anVar) {
        this.ccc = anVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        this.ccc.z(1.0f);
    }
}
