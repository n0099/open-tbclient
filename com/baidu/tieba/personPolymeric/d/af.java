package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ ab eFx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar) {
        this.eFx = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        tbPageContext = this.eFx.aat;
        TiebaStatic.eventStat(tbPageContext.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        tbPageContext2 = this.eFx.aat;
        bg.aL(tbPageContext2.getPageActivity());
    }
}
