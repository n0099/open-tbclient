package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class em implements View.OnClickListener {
    final /* synthetic */ dz cSw;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.r cSy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(dz dzVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        this.cSw = dzVar;
        this.cSy = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10630").aa("obj_id", this.cSy.getAuthor().getUserId()));
        pbActivity = this.cSw.cNL;
        if (pbActivity.cML.cSE != null) {
            pbActivity2 = this.cSw.cNL;
            pbActivity2.cML.cSE.onClick(view);
        }
    }
}
