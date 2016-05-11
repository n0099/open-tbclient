package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fg implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dpA;
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(el elVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dpu = elVar;
        this.dpA = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10630").ac("obj_id", this.dpA.getAuthor().getUserId()));
        pbActivity = this.dpu.dhY;
        if (pbActivity.diS.dpJ != null) {
            pbActivity2 = this.dpu.dhY;
            pbActivity2.diS.dpJ.onClick(view);
        }
    }
}
