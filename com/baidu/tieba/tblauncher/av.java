package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class av implements SlidingMenu.OnClosedListener {
    final /* synthetic */ ai crN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ai aiVar) {
        this.crN = aiVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    public void onClosed() {
        this.crN.x(1.0f);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007012));
    }
}
