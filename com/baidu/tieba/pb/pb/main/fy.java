package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fy implements View.OnClickListener {
    final /* synthetic */ ez eqf;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.p eqm;
    private final /* synthetic */ com.baidu.tieba.pb.data.f eqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fy(ez ezVar, com.baidu.tieba.tbadkCore.data.p pVar, com.baidu.tieba.pb.data.f fVar) {
        this.eqf = ezVar;
        this.eqm = pVar;
        this.eqn = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10630").ab("obj_id", this.eqm.getAuthor().getUserId()));
        if (this.eqn.aJZ() != null && this.eqn.aJZ().rN() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11923").s("obj_id", 3));
        }
        pbActivity = this.eqf.ehi;
        if (pbActivity.ehW.eqy != null) {
            pbActivity2 = this.eqf.ehi;
            pbActivity2.ehW.eqy.onClick(view);
        }
    }
}
