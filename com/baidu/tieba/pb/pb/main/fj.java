package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fj implements View.OnClickListener {
    final /* synthetic */ eu dnc;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dnf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fj(eu euVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dnc = euVar;
        this.dnf = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10630").ac("obj_id", this.dnf.getAuthor().getUserId()));
        pbActivity = this.dnc.dfw;
        if (pbActivity.dgG.dnw != null) {
            pbActivity2 = this.dnc.dfw;
            pbActivity2.dgG.dnw.onClick(view);
        }
    }
}
