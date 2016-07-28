package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ af eka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(af afVar) {
        this.eka = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity.a aVar;
        NewSubPbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.eka.egQ;
        if (dialog != null) {
            dialog2 = this.eka.egQ;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eka.egQ;
                newSubPbActivity = this.eka.ejw;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            aVar = this.eka.ejR;
            if (aVar != null) {
                aVar2 = this.eka.ejR;
                aVar2.g(new Object[]{sparseArray.get(u.g.tag_manage_user_identity), sparseArray.get(u.g.tag_forbid_user_name), sparseArray.get(u.g.tag_forbid_user_post_id)});
            }
        }
    }
}
