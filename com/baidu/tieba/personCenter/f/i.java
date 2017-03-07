package com.baidu.tieba.personCenter.f;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ g eDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.eDs = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.eDs.aaI;
        TiebaStatic.eventStat(tbPageContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        tbPageContext2 = this.eDs.aaI;
        bg.aH(tbPageContext2.getPageActivity());
    }
}
