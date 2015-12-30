package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp implements View.OnClickListener {
    final /* synthetic */ dk cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(dk dkVar) {
        this.cKg = dkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.cKg.cIU;
        if (dialog != null) {
            dialog2 = this.cKg.cIU;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cKg.cIU;
                pbActivity = this.cKg.cGj;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.cKg.a(((Integer) sparseArray.get(n.g.tag_del_post_type)).intValue(), (String) sparseArray.get(n.g.tag_del_post_id), ((Integer) sparseArray.get(n.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(n.g.tag_del_post_is_self)).booleanValue());
        }
    }
}
