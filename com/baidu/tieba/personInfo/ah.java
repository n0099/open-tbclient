package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(d dVar) {
        this.cSn = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.eventStat(this.cSn.getActivity(), "notlogin_10", "click", 1, new Object[0]);
        bj.af(this.cSn.getActivity());
    }
}
