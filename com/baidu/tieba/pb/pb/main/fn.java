package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fn implements View.OnClickListener {
    final /* synthetic */ ey eCT;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q eCW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(ey eyVar, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.eCT = eyVar;
        this.eCW = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10630").ab("obj_id", this.eCW.getAuthor().getUserId()));
        pbActivity = this.eCT.eug;
        if (pbActivity.euQ.eDj != null) {
            pbActivity2 = this.eCT.eug;
            pbActivity2.euQ.eDj.onClick(view);
        }
    }
}
