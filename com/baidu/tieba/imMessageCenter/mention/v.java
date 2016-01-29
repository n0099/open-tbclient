package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ k cmS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(k kVar) {
        this.cmS = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bd bdVar;
        bd bdVar2;
        bdVar = this.cmS.cmQ;
        TiebaStatic.eventStat(bdVar.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        bdVar2 = this.cmS.cmQ;
        com.baidu.tbadk.core.util.bi.af(bdVar2.getPageContext().getPageActivity());
    }
}
