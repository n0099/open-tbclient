package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fi implements View.OnClickListener {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi(ey eyVar) {
        this.erv = eyVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.erv.epP;
        if (dialog != null) {
            dialog2 = this.erv.epP;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.erv.epP;
                pbActivity = this.erv.eig;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        aVar = this.erv.ero;
        if (aVar == null) {
            return;
        }
        aVar2 = this.erv.ero;
        aVar2.g(new Object[]{sparseArray.get(w.h.tag_manage_user_identity), sparseArray.get(w.h.tag_forbid_user_name), sparseArray.get(w.h.tag_forbid_user_post_id)});
    }
}
