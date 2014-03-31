package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bu implements View.OnClickListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Dialog dialog;
        aw awVar;
        aw awVar2;
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
        awVar = this.a.aV;
        if (awVar == null) {
            return;
        }
        awVar2 = this.a.aV;
        awVar2.a(new Object[]{sparseArray.get(com.baidu.tieba.a.h.tag_manage_user_identity), sparseArray.get(com.baidu.tieba.a.h.tag_forbid_user_name)});
    }
}
