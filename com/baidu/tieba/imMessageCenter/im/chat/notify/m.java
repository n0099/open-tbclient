package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ d bsw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar) {
        this.bsw = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdBaseFragmentActivity bdBaseFragmentActivity;
        BdBaseFragmentActivity bdBaseFragmentActivity2;
        bdBaseFragmentActivity = this.bsw.bsk;
        TiebaStatic.eventStat(bdBaseFragmentActivity.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        bdBaseFragmentActivity2 = this.bsw.bsk;
        bq.ac(bdBaseFragmentActivity2.getPageContext().getPageActivity());
    }
}
