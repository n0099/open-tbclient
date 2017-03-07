package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fr implements View.OnClickListener {
    final /* synthetic */ fa etn;
    private final /* synthetic */ boolean etq;
    private final /* synthetic */ PostData etr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fr(fa faVar, PostData postData, boolean z) {
        this.etn = faVar;
        this.etr = postData;
        this.etq = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").Z("obj_id", this.etr.getAuthor().getUserId()));
        if (this.etq) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11923").s("obj_id", 3));
        }
        pbActivity = this.etn.eka;
        if (pbActivity.ekN.etF != null) {
            pbActivity2 = this.etn.eka;
            pbActivity2.ekN.etF.onClick(view);
        }
    }
}
