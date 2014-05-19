package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    final /* synthetic */ bj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bj bjVar) {
        this.a = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.a.ae;
        if (dialog != null) {
            dialog2 = this.a.ae;
            dialog2.dismiss();
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.a.a(((Integer) sparseArray.get(com.baidu.tieba.r.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.r.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.r.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.r.tag_del_post_is_self)).booleanValue());
        }
    }
}
