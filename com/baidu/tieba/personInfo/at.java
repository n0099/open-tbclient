package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(f fVar) {
        this.this$0 = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        baseFragmentActivity = this.this$0.aJw;
        TiebaStatic.eventStat(baseFragmentActivity.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        baseFragmentActivity2 = this.this$0.aJw;
        com.baidu.tbadk.core.util.bl.ab(baseFragmentActivity2.getPageContext().getPageActivity());
    }
}
