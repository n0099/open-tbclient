package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ k dzt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(k kVar) {
        this.dzt = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf bfVar;
        bf bfVar2;
        bfVar = this.dzt.dzq;
        TiebaStatic.eventStat(bfVar.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        bfVar2 = this.dzt.dzq;
        com.baidu.tbadk.core.util.bk.ai(bfVar2.getPageContext().getPageActivity());
    }
}
