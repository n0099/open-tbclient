package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements View.OnClickListener {
    final /* synthetic */ da cGh;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.o cGi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(da daVar, com.baidu.tieba.tbadkCore.data.o oVar) {
        this.cGh = daVar;
        this.cGi = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10630").ab("obj_id", this.cGi.getAuthor().getUserId()));
        pbActivity = this.cGh.cCy;
        if (pbActivity.cBM.cGn != null) {
            pbActivity2 = this.cGh.cCy;
            pbActivity2.cBM.cGn.onClick(view);
        }
    }
}
