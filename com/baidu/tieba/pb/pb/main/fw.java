package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fw implements View.OnClickListener {
    private final /* synthetic */ PostData erB;
    private final /* synthetic */ com.baidu.tieba.pb.data.f erC;
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(ey eyVar, PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.erv = eyVar;
        this.erB = postData;
        this.erC = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").aa("obj_id", this.erB.getAuthor().getUserId()));
        if (this.erC.aJx() != null && this.erC.aJx().sF() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11923").s("obj_id", 3));
        }
        pbActivity = this.erv.eig;
        if (pbActivity.eiT.erI != null) {
            pbActivity2 = this.erv.eig;
            pbActivity2.eiT.erI.onClick(view);
        }
    }
}
