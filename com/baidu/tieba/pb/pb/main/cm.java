package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements View.OnClickListener {
    final /* synthetic */ ch bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(ch chVar) {
        this.bOG = chVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.bOG.bNM;
        if (dialog != null) {
            dialog2 = this.bOG.bNM;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.bOG.bNM;
                pbActivity = this.bOG.bLa;
                com.baidu.adp.lib.g.k.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.bOG.a(((Integer) sparseArray.get(com.baidu.tieba.q.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.q.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue());
        }
    }
}
