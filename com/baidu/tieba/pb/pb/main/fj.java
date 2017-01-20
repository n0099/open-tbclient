package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fj implements View.OnClickListener {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fj(ez ezVar) {
        this.eqf = ezVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.eqf.eoD;
        if (dialog != null) {
            dialog2 = this.eqf.eoD;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eqf.eoD;
                pbActivity = this.eqf.ehi;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.eqf.a(((Integer) sparseArray.get(r.h.tag_del_post_type)).intValue(), (String) sparseArray.get(r.h.tag_del_post_id), ((Integer) sparseArray.get(r.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.h.tag_del_post_is_self)).booleanValue());
        }
    }
}
