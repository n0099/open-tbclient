package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fs implements View.OnClickListener {
    final /* synthetic */ ex euB;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q euH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fs(ex exVar, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.euB = exVar;
        this.euH = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10630").ab("obj_id", this.euH.getAuthor().getUserId()));
        pbActivity = this.euB.emy;
        if (pbActivity.eni.euQ != null) {
            pbActivity2 = this.euB.emy;
            pbActivity2.eni.euQ.onClick(view);
        }
    }
}
