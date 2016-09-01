package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ f dnI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(f fVar) {
        this.dnI = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdBaseFragmentActivity bdBaseFragmentActivity;
        BdBaseFragmentActivity bdBaseFragmentActivity2;
        bdBaseFragmentActivity = this.dnI.dnw;
        TiebaStatic.eventStat(bdBaseFragmentActivity.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        bdBaseFragmentActivity2 = this.dnI.dnw;
        bn.aj(bdBaseFragmentActivity2.getPageContext().getPageActivity());
    }
}
