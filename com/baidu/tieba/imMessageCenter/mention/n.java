package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ l dme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.dme = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.g gVar;
        com.baidu.adp.base.g gVar2;
        gVar = this.dme.mContext;
        TiebaStatic.eventStat(gVar.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        gVar2 = this.dme.mContext;
        com.baidu.tbadk.core.util.bg.aH(gVar2.getPageActivity());
    }
}
