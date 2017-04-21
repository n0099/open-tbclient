package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements View.OnClickListener {
    final /* synthetic */ cn emZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cn cnVar) {
        this.emZ = cnVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.data.f fVar;
        cn cnVar = this.emZ;
        fVar = this.emZ.ejx;
        cnVar.b(fVar);
        this.emZ.notifyDataSetChanged();
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11926"));
    }
}
