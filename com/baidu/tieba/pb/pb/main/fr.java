package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fr implements View.OnClickListener {
    final /* synthetic */ ez eqf;
    private final /* synthetic */ boolean eqj;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.p eqk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fr(ez ezVar, com.baidu.tieba.tbadkCore.data.p pVar, boolean z) {
        this.eqf = ezVar;
        this.eqk = pVar;
        this.eqj = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10630").ab("obj_id", this.eqk.getAuthor().getUserId()));
        if (this.eqj) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11923").s("obj_id", 3));
        }
        pbActivity = this.eqf.ehi;
        if (pbActivity.ehW.eqy != null) {
            pbActivity2 = this.eqf.ehi;
            pbActivity2.ehW.eqy.onClick(view);
        }
    }
}
