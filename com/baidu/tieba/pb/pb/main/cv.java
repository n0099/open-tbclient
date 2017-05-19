package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements View.OnClickListener {
    final /* synthetic */ cq eiw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cq cqVar) {
        this.eiw = cqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.data.f fVar;
        cq cqVar = this.eiw;
        fVar = this.eiw.eeB;
        cqVar.a(fVar, false);
        this.eiw.notifyDataSetChanged();
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11926"));
    }
}
