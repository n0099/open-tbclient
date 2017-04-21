package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fo implements View.OnClickListener {
    final /* synthetic */ ey etN;
    private final /* synthetic */ boolean etQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(ey eyVar, boolean z) {
        this.etN = eyVar;
        this.etQ = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (this.etQ) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11923").s("obj_id", 2));
        }
        pbActivity = this.etN.ekw;
        if (pbActivity.elj.eua != null) {
            pbActivity2 = this.etN.ekw;
            pbActivity2.elj.eua.onClick(view);
        }
    }
}
