package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fm implements View.OnClickListener {
    final /* synthetic */ ex ewH;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q ewK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(ex exVar, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.ewH = exVar;
        this.ewK = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10630").ab("obj_id", this.ewK.getAuthor().getUserId()));
        pbActivity = this.ewH.eow;
        if (pbActivity.epf.ewW != null) {
            pbActivity2 = this.ewH.eow;
            pbActivity2.epf.ewW.onClick(view);
        }
    }
}
