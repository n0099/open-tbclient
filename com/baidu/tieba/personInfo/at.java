package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(h hVar) {
        this.this$0 = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.eventStat(this.this$0.getActivity(), "notlogin_10", "click", 1, new Object[0]);
        com.baidu.tbadk.core.util.bn.Z(this.this$0.getActivity());
    }
}
