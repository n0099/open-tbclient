package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements View.OnClickListener {
    private final /* synthetic */ long bau;
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(da daVar, long j) {
        this.cGh = daVar;
        this.bau = j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10626").ab("obj_id", String.valueOf(this.bau)));
        pbActivity = this.cGh.cCy;
        if (pbActivity.cBM.cGn != null) {
            pbActivity2 = this.cGh.cCy;
            pbActivity2.cBM.cGn.onClick(view);
        }
    }
}
