package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    final /* synthetic */ bv byW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bv bvVar) {
        this.byW = bvVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.byW.byb;
        if (dialog != null) {
            dialog2 = this.byW.byb;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.byW.byb;
                pbActivity = this.byW.bxe;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity);
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.byW.a(((Integer) sparseArray.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
        }
    }
}
