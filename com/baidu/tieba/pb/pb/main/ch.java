package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements View.OnClickListener {
    final /* synthetic */ cc cly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cc ccVar) {
        this.cly = ccVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.cly.ckF;
        if (dialog != null) {
            dialog2 = this.cly.ckF;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cly.ckF;
                pbActivity = this.cly.ciJ;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        aVar = this.cly.clv;
        if (aVar == null) {
            return;
        }
        aVar2 = this.cly.clv;
        aVar2.d(new Object[]{sparseArray.get(i.f.tag_manage_user_identity), sparseArray.get(i.f.tag_forbid_user_name), sparseArray.get(i.f.tag_forbid_user_post_id)});
    }
}
