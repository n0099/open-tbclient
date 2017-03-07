package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fx implements View.OnClickListener {
    final /* synthetic */ fa etn;
    private final /* synthetic */ PostData ett;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fx(fa faVar, PostData postData) {
        this.etn = faVar;
        this.ett = postData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").Z("obj_id", this.ett.getAuthor().getUserId()));
        pbActivity = this.etn.eka;
        if (pbActivity.ekN.etF != null) {
            pbActivity2 = this.etn.eka;
            pbActivity2.ekN.etF.onClick(view);
        }
    }
}
