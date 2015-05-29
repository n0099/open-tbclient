package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements View.OnClickListener {
    final /* synthetic */ ch bOF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(ch chVar) {
        this.bOF = chVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        bc bcVar;
        bc bcVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.bOF.bNL;
        if (dialog != null) {
            dialog2 = this.bOF.bNL;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.bOF.bNL;
                pbActivity = this.bOF.bKZ;
                com.baidu.adp.lib.g.k.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        bcVar = this.bOF.bOB;
        if (bcVar == null) {
            return;
        }
        bcVar2 = this.bOF.bOB;
        bcVar2.c(new Object[]{sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity), sparseArray.get(com.baidu.tieba.q.tag_forbid_user_name), sparseArray.get(com.baidu.tieba.q.tag_forbid_user_post_id)});
    }
}
