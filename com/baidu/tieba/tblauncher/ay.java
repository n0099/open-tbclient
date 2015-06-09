package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class ay implements SlidingMenu.OnClosedListener {
    final /* synthetic */ aj cwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aj ajVar) {
        this.cwo = ajVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        this.cwo.y(1.0f);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007012));
    }
}
