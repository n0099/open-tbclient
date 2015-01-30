package com.baidu.tieba.tblauncher;

import android.view.View;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ ai cdw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ai aiVar) {
        this.cdw = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SlidingMenu slidingMenu;
        slidingMenu = this.cdw.aFG;
        slidingMenu.toggle(true);
    }
}
