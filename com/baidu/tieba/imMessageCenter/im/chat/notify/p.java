package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ e bKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(e eVar) {
        this.bKG = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdBaseFragmentActivity bdBaseFragmentActivity;
        BdBaseFragmentActivity bdBaseFragmentActivity2;
        bdBaseFragmentActivity = this.bKG.bKu;
        TiebaStatic.eventStat(bdBaseFragmentActivity.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        bdBaseFragmentActivity2 = this.bKG.bKu;
        bd.af(bdBaseFragmentActivity2.getPageContext().getPageActivity());
    }
}
