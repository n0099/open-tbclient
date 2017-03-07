package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fq implements View.OnClickListener {
    final /* synthetic */ fa etn;
    private final /* synthetic */ boolean etq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(fa faVar, boolean z) {
        this.etn = faVar;
        this.etq = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (this.etq) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11923").s("obj_id", 2));
        }
        pbActivity = this.etn.eka;
        if (pbActivity.ekN.etF != null) {
            pbActivity2 = this.etn.eka;
            pbActivity2.ekN.etF.onClick(view);
        }
    }
}
