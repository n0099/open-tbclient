package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fl implements View.OnClickListener {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(ez ezVar) {
        this.eqf = ezVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.eqf.eoD;
        if (dialog != null) {
            dialog2 = this.eqf.eoD;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eqf.eoD;
                pbActivity = this.eqf.ehi;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        aVar = this.eqf.epY;
        if (aVar == null) {
            return;
        }
        aVar2 = this.eqf.epY;
        aVar2.g(new Object[]{sparseArray.get(r.h.tag_manage_user_identity), sparseArray.get(r.h.tag_forbid_user_name), sparseArray.get(r.h.tag_forbid_user_post_id)});
    }
}
