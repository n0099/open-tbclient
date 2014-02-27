package com.baidu.tieba.pb;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class db implements View.OnClickListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Dialog dialog;
        cb cbVar;
        cb cbVar2;
        Dialog dialog2;
        dialog = this.a.K;
        if (dialog != null) {
            dialog2 = this.a.K;
            dialog2.dismiss();
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        cbVar = this.a.aw;
        if (cbVar == null) {
            return;
        }
        cbVar2 = this.a.aw;
        cbVar2.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name)});
    }
}
