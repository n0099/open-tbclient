package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements View.OnClickListener {
    final /* synthetic */ bz bEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(bz bzVar) {
        this.bEC = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        bg bgVar;
        bg bgVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.bEC.bDE;
        if (dialog != null) {
            dialog2 = this.bEC.bDE;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.bEC.bDE;
                pbActivity = this.bEC.bCG;
                com.baidu.adp.lib.g.k.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        bgVar = this.bEC.bEy;
        if (bgVar == null) {
            return;
        }
        bgVar2 = this.bEC.bEy;
        bgVar2.c(new Object[]{sparseArray.get(com.baidu.tieba.w.tag_manage_user_identity), sparseArray.get(com.baidu.tieba.w.tag_forbid_user_name), sparseArray.get(com.baidu.tieba.w.tag_forbid_user_post_id)});
    }
}
