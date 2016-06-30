package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fh implements View.OnClickListener {
    final /* synthetic */ es dVR;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dVU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(es esVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dVR = esVar;
        this.dVU = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10630").ab("obj_id", this.dVU.getAuthor().getUserId()));
        pbActivity = this.dVR.dOg;
        if (pbActivity.dOP.dWg != null) {
            pbActivity2 = this.dVR.dOg;
            pbActivity2.dOP.dWg.onClick(view);
        }
    }
}
