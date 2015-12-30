package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ k cis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(k kVar) {
        this.cis = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bd bdVar;
        bd bdVar2;
        bdVar = this.cis.ciq;
        TiebaStatic.eventStat(bdVar.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        bdVar2 = this.cis.ciq;
        bj.af(bdVar2.getPageContext().getPageActivity());
    }
}
