package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(f fVar) {
        this.diG = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        baseFragmentActivity = this.diG.aKq;
        TiebaStatic.eventStat(baseFragmentActivity.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
        baseFragmentActivity2 = this.diG.aKq;
        com.baidu.tbadk.core.util.bi.af(baseFragmentActivity2.getPageContext().getPageActivity());
    }
}
