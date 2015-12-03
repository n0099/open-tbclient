package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ k ceq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(k kVar) {
        this.ceq = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bc bcVar;
        bc bcVar2;
        bcVar = this.ceq.cep;
        TiebaStatic.eventStat(bcVar.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        bcVar2 = this.ceq.cep;
        bj.af(bcVar2.getPageContext().getPageActivity());
    }
}
