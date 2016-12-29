package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fg implements View.OnClickListener {
    final /* synthetic */ er egZ;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q ehc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(er erVar, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.egZ = erVar;
        this.ehc = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10630").ab("obj_id", this.ehc.getAuthor().getUserId()));
        pbActivity = this.egZ.dYB;
        if (pbActivity.dZl.ehp != null) {
            pbActivity2 = this.egZ.dYB;
            pbActivity2.dZl.ehp.onClick(view);
        }
    }
}
