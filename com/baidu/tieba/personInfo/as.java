package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(f fVar) {
        this.this$0 = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.eventStat(this.this$0.getActivity(), "notlogin_10", "click", 1, new Object[0]);
        com.baidu.tbadk.core.util.bl.aa(this.this$0.getActivity());
    }
}
