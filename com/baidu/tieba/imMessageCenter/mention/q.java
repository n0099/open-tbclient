package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ o dcz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.dcz = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        hVar = this.dcz.mContext;
        TiebaStatic.eventStat(hVar.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        hVar2 = this.dcz.mContext;
        com.baidu.tbadk.core.util.bh.ah(hVar2.getPageActivity());
    }
}
