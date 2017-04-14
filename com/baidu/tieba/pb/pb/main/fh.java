package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fh implements View.OnClickListener {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(ey eyVar) {
        this.erv = eyVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.erv.epP;
        if (dialog != null) {
            dialog2 = this.erv.epP;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.erv.epP;
                pbActivity = this.erv.eig;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.erv.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
        }
    }
}
