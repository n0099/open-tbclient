package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ bv byI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bv bvVar) {
        this.byI = bvVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        bf bfVar;
        bf bfVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.byI.bxN;
        if (dialog != null) {
            dialog2 = this.byI.bxN;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.byI.bxN;
                pbActivity = this.byI.bwQ;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity);
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        bfVar = this.byI.byE;
        if (bfVar == null) {
            return;
        }
        bfVar2 = this.byI.byE;
        bfVar2.a(new Object[]{sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity), sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name)});
    }
}
