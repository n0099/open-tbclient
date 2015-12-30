package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ w cLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(w wVar) {
        this.cLC = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.cLC.cIU;
        if (dialog != null) {
            dialog2 = this.cLC.cIU;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cLC.cIU;
                newSubPbActivity = this.cLC.cLg;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.cLC.a(((Integer) sparseArray.get(n.g.tag_del_post_type)).intValue(), (String) sparseArray.get(n.g.tag_del_post_id), ((Integer) sparseArray.get(n.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(n.g.tag_del_post_is_self)).booleanValue());
        }
    }
}
