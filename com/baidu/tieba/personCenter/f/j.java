package com.baidu.tieba.personCenter.f;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ g eBp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.eBp = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.eBp.aaX;
        TiebaStatic.eventStat(tbPageContext.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        tbPageContext2 = this.eBp.aaX;
        bg.aI(tbPageContext2.getPageActivity());
    }
}
