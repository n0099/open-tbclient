package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ ao eFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(ao aoVar) {
        this.eFb = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.eFb.eBr;
        if (dialog != null) {
            dialog2 = this.eFb.eBr;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eFb.eBr;
                newSubPbActivity = this.eFb.eEy;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.eFb.a(((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray.get(r.g.tag_del_post_id), ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.g.tag_del_post_is_self)).booleanValue());
        }
    }
}
