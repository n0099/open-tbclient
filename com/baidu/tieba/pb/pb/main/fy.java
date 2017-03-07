package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fy implements View.OnClickListener {
    final /* synthetic */ fa etn;
    private final /* synthetic */ PostData ett;
    private final /* synthetic */ com.baidu.tieba.pb.data.f etu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fy(fa faVar, PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.etn = faVar;
        this.ett = postData;
        this.etu = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").Z("obj_id", this.ett.getAuthor().getUserId()));
        if (this.etu.aJq() != null && this.etu.aJq().sh() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11923").s("obj_id", 3));
        }
        pbActivity = this.etn.eka;
        if (pbActivity.ekN.etF != null) {
            pbActivity2 = this.etn.eka;
            pbActivity2.ekN.etF.onClick(view);
        }
    }
}
