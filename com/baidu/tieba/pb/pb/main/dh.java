package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements View.OnClickListener {
    final /* synthetic */ dc exj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(dc dcVar) {
        this.exj = dcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.data.f fVar;
        dc dcVar = this.exj;
        fVar = this.exj.eta;
        dcVar.a(fVar, false);
        this.exj.notifyDataSetChanged();
        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11926"));
    }
}
