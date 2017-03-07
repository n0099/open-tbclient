package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fk implements View.OnClickListener {
    final /* synthetic */ fa etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(fa faVar) {
        this.etn = faVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.etn.erG;
        if (dialog != null) {
            dialog2 = this.etn.erG;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.etn.erG;
                pbActivity = this.etn.eka;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        aVar = this.etn.etg;
        if (aVar == null) {
            return;
        }
        aVar2 = this.etn.etg;
        aVar2.g(new Object[]{sparseArray.get(w.h.tag_manage_user_identity), sparseArray.get(w.h.tag_forbid_user_name), sparseArray.get(w.h.tag_forbid_user_post_id)});
    }
}
