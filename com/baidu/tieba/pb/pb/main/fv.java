package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fv implements View.OnClickListener {
    private final /* synthetic */ PostData erB;
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fv(ey eyVar, PostData postData) {
        this.erv = eyVar;
        this.erB = postData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").aa("obj_id", this.erB.getAuthor().getUserId()));
        pbActivity = this.erv.eig;
        if (pbActivity.eiT.erI != null) {
            pbActivity2 = this.erv.eig;
            pbActivity2.eiT.erI.onClick(view);
        }
    }
}
