package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fp implements View.OnClickListener {
    final /* synthetic */ ey etN;
    private final /* synthetic */ boolean etQ;
    private final /* synthetic */ PostData etR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(ey eyVar, PostData postData, boolean z) {
        this.etN = eyVar;
        this.etR = postData;
        this.etQ = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").aa("obj_id", this.etR.getAuthor().getUserId()));
        if (this.etQ) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11923").s("obj_id", 3));
        }
        pbActivity = this.etN.ekw;
        if (pbActivity.elj.eua != null) {
            pbActivity2 = this.etN.ekw;
            pbActivity2.elj.eua.onClick(view);
        }
    }
}
