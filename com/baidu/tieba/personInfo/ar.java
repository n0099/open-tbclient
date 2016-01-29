package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(f fVar) {
        this.diG = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.eventStat(this.diG.getActivity(), "notlogin_10", "click", 1, new Object[0]);
        com.baidu.tbadk.core.util.bi.af(this.diG.getActivity());
    }
}
