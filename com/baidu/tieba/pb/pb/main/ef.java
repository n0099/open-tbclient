package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ef implements View.OnClickListener {
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(dz dzVar) {
        this.cSw = dzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.cSw.cQZ;
        if (dialog != null) {
            dialog2 = this.cSw.cQZ;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cSw.cQZ;
                pbActivity = this.cSw.cNL;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.cSw.a(((Integer) sparseArray.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray.get(t.g.tag_del_post_id), ((Integer) sparseArray.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(t.g.tag_del_post_is_self)).booleanValue());
        }
    }
}
