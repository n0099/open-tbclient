package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    final /* synthetic */ bt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bt btVar) {
        this.a = btVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.a.ac;
        if (dialog != null) {
            dialog2 = this.a.ac;
            dialog2.dismiss();
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.a.a(((Integer) sparseArray.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
        }
    }
}
