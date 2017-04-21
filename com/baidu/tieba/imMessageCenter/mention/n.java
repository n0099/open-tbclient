package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ l dmU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.dmU = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.g gVar;
        com.baidu.adp.base.g gVar2;
        gVar = this.dmU.mContext;
        TiebaStatic.eventStat(gVar.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        gVar2 = this.dmU.mContext;
        com.baidu.tbadk.core.util.bg.aJ(gVar2.getPageActivity());
    }
}
