package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ k ddP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(k kVar) {
        this.ddP = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf bfVar;
        bf bfVar2;
        bfVar = this.ddP.ddM;
        TiebaStatic.eventStat(bfVar.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        bfVar2 = this.ddP.ddM;
        bn.Z(bfVar2.getPageContext().getPageActivity());
    }
}
