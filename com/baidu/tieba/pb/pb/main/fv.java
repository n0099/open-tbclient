package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fv implements View.OnClickListener {
    final /* synthetic */ ey etN;
    private final /* synthetic */ PostData etT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fv(ey eyVar, PostData postData) {
        this.etN = eyVar;
        this.etT = postData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").aa("obj_id", this.etT.getAuthor().getUserId()));
        pbActivity = this.etN.ekw;
        if (pbActivity.elj.eua != null) {
            pbActivity2 = this.etN.ekw;
            pbActivity2.elj.eua.onClick(view);
        }
    }
}
