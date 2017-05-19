package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gc implements View.OnClickListener {
    final /* synthetic */ fm epr;
    private final /* synthetic */ boolean epu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(fm fmVar, boolean z) {
        this.epr = fmVar;
        this.epu = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (this.epu) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11923").s("obj_id", 2));
        }
        pbActivity = this.epr.efF;
        if (pbActivity.egu.epB != null) {
            pbActivity2 = this.epr.efF;
            pbActivity2.egu.epB.onClick(view);
        }
    }
}
