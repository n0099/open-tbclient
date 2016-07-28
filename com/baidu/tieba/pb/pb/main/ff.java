package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ff implements View.OnClickListener {
    final /* synthetic */ ew eiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(ew ewVar) {
        this.eiu = ewVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
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
        if (sparseArray == null) {
            return;
        }
        aVar = this.eiu.ein;
        if (aVar == null) {
            return;
        }
        aVar2 = this.eiu.ein;
        aVar2.g(new Object[]{sparseArray.get(u.g.tag_manage_user_identity), sparseArray.get(u.g.tag_forbid_user_name), sparseArray.get(u.g.tag_forbid_user_post_id)});
    }
}
