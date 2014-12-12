package com.baidu.tieba.tblauncher;

import android.view.View;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ an ccc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(an anVar) {
        this.ccc = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SlidingMenu slidingMenu;
        slidingMenu = this.ccc.aED;
        slidingMenu.toggle(true);
    }
}
