package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ w cHA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(w wVar) {
        this.cHA = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity.a aVar;
        NewSubPbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.cHA.cEV;
        if (dialog != null) {
            dialog2 = this.cHA.cEV;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cHA.cEV;
                newSubPbActivity = this.cHA.cHi;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            aVar = this.cHA.cHs;
            if (aVar != null) {
                aVar2 = this.cHA.cHs;
                aVar2.d(new Object[]{sparseArray.get(n.f.tag_manage_user_identity), sparseArray.get(n.f.tag_forbid_user_name), sparseArray.get(n.f.tag_forbid_user_post_id)});
            }
        }
    }
}
