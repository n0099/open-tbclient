package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements View.OnClickListener {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        be beVar;
        be beVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.bMm.bLs;
        if (dialog != null) {
            dialog2 = this.bMm.bLs;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.bMm.bLs;
                pbActivity = this.bMm.bIF;
                com.baidu.adp.lib.g.k.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        beVar = this.bMm.bMi;
        if (beVar == null) {
            return;
        }
        beVar2 = this.bMm.bMi;
        beVar2.c(new Object[]{sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity), sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name), sparseArray.get(com.baidu.tieba.v.tag_forbid_user_post_id)});
    }
}
