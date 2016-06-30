package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(f fVar) {
        this.this$0 = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        baseFragmentActivity = this.this$0.aMU;
        TiebaStatic.eventStat(baseFragmentActivity.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
        baseFragmentActivity2 = this.this$0.aMU;
        com.baidu.tbadk.core.util.bn.Z(baseFragmentActivity2.getPageContext().getPageActivity());
    }
}
