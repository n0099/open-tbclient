package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fa implements View.OnClickListener {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(es esVar) {
        this.dVR = esVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.dVR.dUp;
        if (dialog != null) {
            dialog2 = this.dVR.dUp;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.dVR.dUp;
                pbActivity = this.dVR.dOg;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.dVR.a(((Integer) sparseArray.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray.get(u.g.tag_del_post_id), ((Integer) sparseArray.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(u.g.tag_del_post_is_self)).booleanValue());
        }
    }
}
