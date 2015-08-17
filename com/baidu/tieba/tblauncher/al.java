package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ ai cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ai aiVar) {
        this.cMQ = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SlidingMenu slidingMenu;
        if (MainTabActivityConfig.IS_SUPPORT_LEFT_BAR) {
            slidingMenu = this.cMQ.bbA;
            slidingMenu.toggle(true);
        }
    }
}
