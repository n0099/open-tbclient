package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ ao ejb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ao aoVar) {
        this.ejb = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity.a aVar;
        NewSubPbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.ejb.efx;
        if (dialog != null) {
            dialog2 = this.ejb.efx;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.ejb.efx;
                newSubPbActivity = this.ejb.eiy;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            aVar = this.ejb.eiP;
            if (aVar != null) {
                aVar2 = this.ejb.eiP;
                aVar2.g(new Object[]{sparseArray.get(r.g.tag_manage_user_identity), sparseArray.get(r.g.tag_forbid_user_name), sparseArray.get(r.g.tag_forbid_user_post_id)});
            }
        }
    }
}
