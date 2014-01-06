package com.baidu.tieba.pb;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements View.OnClickListener {
    final /* synthetic */ cs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cs csVar) {
        this.a = csVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        bx bxVar;
        bx bxVar2;
        Dialog dialog2;
        dialog = this.a.J;
        if (dialog != null) {
            dialog2 = this.a.J;
            dialog2.dismiss();
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            bxVar = this.a.ax;
            if (bxVar != null) {
                bxVar2 = this.a.ax;
                bxVar2.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name)});
            }
        }
    }
}
