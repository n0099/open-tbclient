package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements View.OnClickListener {
    final /* synthetic */ cp emB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cp cpVar) {
        this.emB = cpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.data.f fVar;
        cp cpVar = this.emB;
        fVar = this.emB.ejb;
        cpVar.b(fVar);
        this.emB.notifyDataSetChanged();
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11926"));
    }
}
