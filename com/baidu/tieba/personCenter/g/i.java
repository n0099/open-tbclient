package com.baidu.tieba.personCenter.g;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ g eDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.eDX = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.eDX.Gd;
        TiebaStatic.eventStat(tbPageContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        tbPageContext2 = this.eDX.Gd;
        bn.ak(tbPageContext2.getPageActivity());
    }
}
