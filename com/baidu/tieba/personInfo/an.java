package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(d dVar) {
        this.cWV = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.eventStat(this.cWV.getActivity(), "notlogin_10", "click", 1, new Object[0]);
        com.baidu.tbadk.core.util.bj.af(this.cWV.getActivity());
    }
}
