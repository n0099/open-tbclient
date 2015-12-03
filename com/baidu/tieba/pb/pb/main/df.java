package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df implements View.OnClickListener {
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(da daVar) {
        this.cGh = daVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.cGh.cEV;
        if (dialog != null) {
            dialog2 = this.cGh.cEV;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cGh.cEV;
                pbActivity = this.cGh.cCy;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.cGh.a(((Integer) sparseArray.get(n.f.tag_del_post_type)).intValue(), (String) sparseArray.get(n.f.tag_del_post_id), ((Integer) sparseArray.get(n.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(n.f.tag_del_post_is_self)).booleanValue());
        }
    }
}
