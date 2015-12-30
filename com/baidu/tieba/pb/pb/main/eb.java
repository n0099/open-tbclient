package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eb implements View.OnClickListener {
    private final /* synthetic */ long bes;
    final /* synthetic */ dk cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(dk dkVar, long j) {
        this.cKg = dkVar;
        this.bes = j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10626").aa("obj_id", String.valueOf(this.bes)));
        pbActivity = this.cKg.cGj;
        if (pbActivity.cFr.cKm != null) {
            pbActivity2 = this.cKg.cGj;
            pbActivity2.cFr.cKm.onClick(view);
        }
    }
}
