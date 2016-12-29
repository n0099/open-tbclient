package com.baidu.tieba.personCenter.g;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g epW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.epW = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.epW.Gf;
        TiebaStatic.eventStat(tbPageContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
        tbPageContext2 = this.epW.Gf;
        bh.ag(tbPageContext2.getPageActivity());
    }
}
