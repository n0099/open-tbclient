package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fx implements View.OnClickListener {
    final /* synthetic */ ez eqf;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.p eqm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fx(ez ezVar, com.baidu.tieba.tbadkCore.data.p pVar) {
        this.eqf = ezVar;
        this.eqm = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10630").ab("obj_id", this.eqm.getAuthor().getUserId()));
        pbActivity = this.eqf.ehi;
        if (pbActivity.ehW.eqy != null) {
            pbActivity2 = this.eqf.ehi;
            pbActivity2.ehW.eqy.onClick(view);
        }
    }
}
