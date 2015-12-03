package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ w cHA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(w wVar) {
        this.cHA = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
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
            this.cHA.a(((Integer) sparseArray.get(n.f.tag_del_post_type)).intValue(), (String) sparseArray.get(n.f.tag_del_post_id), ((Integer) sparseArray.get(n.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(n.f.tag_del_post_is_self)).booleanValue());
        }
    }
}
