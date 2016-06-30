package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fb implements View.OnClickListener {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(es esVar) {
        this.dVR = esVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.dVR.dUp;
        if (dialog != null) {
            dialog2 = this.dVR.dUp;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.dVR.dUp;
                pbActivity = this.dVR.dOg;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        aVar = this.dVR.dVK;
        if (aVar == null) {
            return;
        }
        aVar2 = this.dVR.dVK;
        aVar2.d(new Object[]{sparseArray.get(u.g.tag_manage_user_identity), sparseArray.get(u.g.tag_forbid_user_name), sparseArray.get(u.g.tag_forbid_user_post_id)});
    }
}
