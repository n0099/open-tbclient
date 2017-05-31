package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ge implements View.OnClickListener {
    final /* synthetic */ fx evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ge(fx fxVar) {
        this.evi = fxVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.evi.etD;
        if (dialog != null) {
            dialog2 = this.evi.etD;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.evi.etD;
                pbActivity = this.evi.elf;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.evi.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
        }
    }
}
