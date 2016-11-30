package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fh implements View.OnClickListener {
    final /* synthetic */ ey eCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(ey eyVar) {
        this.eCT = eyVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.eCT.eBr;
        if (dialog != null) {
            dialog2 = this.eCT.eBr;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eCT.eBr;
                pbActivity = this.eCT.eug;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        aVar = this.eCT.eCM;
        if (aVar == null) {
            return;
        }
        aVar2 = this.eCT.eCM;
        aVar2.g(new Object[]{sparseArray.get(r.g.tag_manage_user_identity), sparseArray.get(r.g.tag_forbid_user_name), sparseArray.get(r.g.tag_forbid_user_post_id)});
    }
}
