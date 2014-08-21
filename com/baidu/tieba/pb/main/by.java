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
        if (sparseArray == null) {
            return;
        }
        bdVar = this.a.ba;
        if (bdVar == null) {
            return;
        }
        bdVar2 = this.a.ba;
        bdVar2.a(new Object[]{sparseArray.get(com.baidu.tieba.u.tag_manage_user_identity), sparseArray.get(com.baidu.tieba.u.tag_forbid_user_name)});
    }
}
