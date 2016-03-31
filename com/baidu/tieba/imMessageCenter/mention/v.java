package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ k cxu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(k kVar) {
        this.cxu = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        be beVar;
        be beVar2;
        beVar = this.cxu.cxs;
        TiebaStatic.eventStat(beVar.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        beVar2 = this.cxu.cxs;
        bl.ab(beVar2.getPageContext().getPageActivity());
    }
}
