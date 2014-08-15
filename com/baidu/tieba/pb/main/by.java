package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        bd bdVar;
        bd bdVar2;
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
        bdVar = this.a.aZ;
        if (bdVar == null) {
            return;
        }
        bdVar2 = this.a.aZ;
        bdVar2.a(new Object[]{sparseArray.get(com.baidu.tieba.u.tag_manage_user_identity), sparseArray.get(com.baidu.tieba.u.tag_forbid_user_name)});
    }
}
