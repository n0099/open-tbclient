package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ l dmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.dmu = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.base.g gVar;
        com.baidu.adp.base.g gVar2;
        gVar = this.dmu.mContext;
        TiebaStatic.eventStat(gVar.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        gVar2 = this.dmu.mContext;
        com.baidu.tbadk.core.util.bh.aM(gVar2.getPageActivity());
    }
}
