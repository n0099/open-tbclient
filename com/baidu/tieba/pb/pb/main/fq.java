package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fq implements View.OnClickListener {
    final /* synthetic */ ez eqf;
    private final /* synthetic */ boolean eqj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(ez ezVar, boolean z) {
        this.eqf = ezVar;
        this.eqj = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (this.eqj) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11923").s("obj_id", 2));
        }
        pbActivity = this.eqf.ehi;
        if (pbActivity.ehW.eqy != null) {
            pbActivity2 = this.eqf.ehi;
            pbActivity2.ehW.eqy.onClick(view);
        }
    }
}
