package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements View.OnClickListener {
    final /* synthetic */ cj bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cj cjVar) {
        this.bMC = cjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        bf bfVar;
        bf bfVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.bMC.bLI;
        if (dialog != null) {
            dialog2 = this.bMC.bLI;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.bMC.bLI;
                pbActivity = this.bMC.bIT;
                com.baidu.adp.lib.g.k.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        bfVar = this.bMC.bMy;
        if (bfVar == null) {
            return;
        }
        bfVar2 = this.bMC.bMy;
        bfVar2.c(new Object[]{sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity), sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name), sparseArray.get(com.baidu.tieba.v.tag_forbid_user_post_id)});
    }
}
