package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fe implements View.OnClickListener {
    final /* synthetic */ ew eiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(ew ewVar) {
        this.eiu = ewVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.eiu.egQ;
        if (dialog != null) {
            dialog2 = this.eiu.egQ;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eiu.egQ;
                pbActivity = this.eiu.eat;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.eiu.a(((Integer) sparseArray.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray.get(u.g.tag_del_post_id), ((Integer) sparseArray.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(u.g.tag_del_post_is_self)).booleanValue());
        }
    }
}
