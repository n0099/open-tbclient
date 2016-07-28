package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fl implements View.OnClickListener {
    final /* synthetic */ ew eiu;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s eix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(ew ewVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.eiu = ewVar;
        this.eix = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10630").ab("obj_id", this.eix.getAuthor().getUserId()));
        pbActivity = this.eiu.eat;
        if (pbActivity.ebc.eiJ != null) {
            pbActivity2 = this.eiu.eat;
            pbActivity2.ebc.eiJ.onClick(view);
        }
    }
}
