package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements View.OnClickListener {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(bz bzVar) {
        this.bCR = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.bCR.bBT;
        if (dialog != null) {
            dialog2 = this.bCR.bBT;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.bCR.bBT;
                pbActivity = this.bCR.bAW;
                com.baidu.adp.lib.g.k.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.bCR.a(((Integer) sparseArray.get(com.baidu.tieba.w.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.w.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue());
        }
    }
}
