package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bw implements View.OnClickListener {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bm bmVar) {
        this.a = bmVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Dialog dialog;
        ay ayVar;
        ay ayVar2;
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
        ayVar = this.a.aX;
        if (ayVar == null) {
            return;
        }
        ayVar2 = this.a.aX;
        ayVar2.a(new Object[]{sparseArray.get(com.baidu.tieba.a.h.tag_manage_user_identity), sparseArray.get(com.baidu.tieba.a.h.tag_forbid_user_name)});
    }
}
