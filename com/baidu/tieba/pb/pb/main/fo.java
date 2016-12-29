package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fo implements View.OnClickListener {
    final /* synthetic */ er egZ;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q ehe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(er erVar, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.egZ = erVar;
        this.ehe = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10630").ab("obj_id", this.ehe.getAuthor().getUserId()));
        pbActivity = this.egZ.dYB;
        if (pbActivity.dZl.ehp != null) {
            pbActivity2 = this.egZ.dYB;
            pbActivity2.dZl.ehp.onClick(view);
        }
    }
}
