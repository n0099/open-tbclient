package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(d dVar) {
        this.cSn = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        baseFragmentActivity = this.cSn.aHN;
        TiebaStatic.eventStat(baseFragmentActivity.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        baseFragmentActivity2 = this.cSn.aHN;
        bj.ag(baseFragmentActivity2.getPageContext().getPageActivity());
    }
}
