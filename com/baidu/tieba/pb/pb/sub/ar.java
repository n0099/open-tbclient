package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ af eka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(af afVar) {
        this.eka = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.eka.egQ;
        if (dialog != null) {
            dialog2 = this.eka.egQ;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eka.egQ;
                newSubPbActivity = this.eka.ejw;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.eka.a(((Integer) sparseArray.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray.get(u.g.tag_del_post_id), ((Integer) sparseArray.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(u.g.tag_del_post_is_self)).booleanValue());
        }
    }
}
