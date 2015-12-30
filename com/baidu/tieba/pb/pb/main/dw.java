package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dw implements View.OnClickListener {
    final /* synthetic */ dk cKg;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.r cKh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(dk dkVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        this.cKg = dkVar;
        this.cKh = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10630").aa("obj_id", this.cKh.getAuthor().getUserId()));
        pbActivity = this.cKg.cGj;
        if (pbActivity.cFr.cKm != null) {
            pbActivity2 = this.cKg.cGj;
            pbActivity2.cFr.cKm.onClick(view);
        }
    }
}
