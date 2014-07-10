package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ bt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bt btVar) {
        this.a = btVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        ba baVar;
        ba baVar2;
        Dialog dialog2;
        dialog = this.a.ac;
        if (dialog != null) {
            dialog2 = this.a.ac;
            dialog2.dismiss();
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        baVar = this.a.aZ;
        if (baVar == null) {
            return;
        }
        baVar2 = this.a.aZ;
        baVar2.a(new Object[]{sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity), sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name)});
    }
}
