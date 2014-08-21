package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements View.OnClickListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.a.ad;
        if (dialog != null) {
            dialog2 = this.a.ad;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.a.ad;
                pbActivity = this.a.k;
                com.baidu.adp.lib.e.e.b(dialog3, pbActivity);
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.a.a(((Integer) sparseArray.get(com.baidu.tieba.u.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.u.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.u.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.u.tag_del_post_is_self)).booleanValue());
        }
    }
}
