package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fo implements View.OnClickListener {
    final /* synthetic */ ey erv;
    private final /* synthetic */ boolean ery;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(ey eyVar, boolean z) {
        this.erv = eyVar;
        this.ery = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (this.ery) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11923").s("obj_id", 2));
        }
        pbActivity = this.erv.eig;
        if (pbActivity.eiT.erI != null) {
            pbActivity2 = this.erv.eig;
            pbActivity2.eiT.erI.onClick(view);
        }
    }
}
