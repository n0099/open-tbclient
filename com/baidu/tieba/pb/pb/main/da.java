package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements View.OnClickListener {
    final /* synthetic */ cv eod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cv cvVar) {
        this.eod = cvVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.data.f fVar;
        cv cvVar = this.eod;
        fVar = this.eod.ekc;
        cvVar.a(fVar, false);
        this.eod.notifyDataSetChanged();
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11926"));
    }
}
