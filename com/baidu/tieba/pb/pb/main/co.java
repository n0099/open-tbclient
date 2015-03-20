package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements View.OnClickListener {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
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
        if (sparseArray != null) {
            this.bMm.a(((Integer) sparseArray.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
        }
    }
}
