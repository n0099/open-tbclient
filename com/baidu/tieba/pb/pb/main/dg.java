package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg implements View.OnClickListener {
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(da daVar) {
        this.cGh = daVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
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
        if (sparseArray == null) {
            return;
        }
        aVar = this.cGh.cGc;
        if (aVar == null) {
            return;
        }
        aVar2 = this.cGh.cGc;
        aVar2.d(new Object[]{sparseArray.get(n.f.tag_manage_user_identity), sparseArray.get(n.f.tag_forbid_user_name), sparseArray.get(n.f.tag_forbid_user_post_id)});
    }
}
