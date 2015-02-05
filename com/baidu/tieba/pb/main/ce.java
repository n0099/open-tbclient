package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnClickListener {
    final /* synthetic */ bz bEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(bz bzVar) {
        this.bEB = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.bEB.bDD;
        if (dialog != null) {
            dialog2 = this.bEB.bDD;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.bEB.bDD;
                pbActivity = this.bEB.bCF;
                com.baidu.adp.lib.g.k.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.bEB.a(((Integer) sparseArray.get(com.baidu.tieba.w.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.w.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue());
        }
    }
}
