package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    final /* synthetic */ bj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bj bjVar) {
        this.a = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        ax axVar;
        ax axVar2;
        Dialog dialog2;
        dialog = this.a.ae;
        if (dialog != null) {
            dialog2 = this.a.ae;
            dialog2.dismiss();
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        axVar = this.a.ba;
        if (axVar == null) {
            return;
        }
        axVar2 = this.a.ba;
        axVar2.a(new Object[]{sparseArray.get(com.baidu.tieba.r.tag_manage_user_identity), sparseArray.get(com.baidu.tieba.r.tag_forbid_user_name)});
    }
}
