package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eg implements View.OnClickListener {
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(dz dzVar) {
        this.cSw = dzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.cSw.cQZ;
        if (dialog != null) {
            dialog2 = this.cSw.cQZ;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cSw.cQZ;
                pbActivity = this.cSw.cNL;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        aVar = this.cSw.cSo;
        if (aVar == null) {
            return;
        }
        aVar2 = this.cSw.cSo;
        aVar2.d(new Object[]{sparseArray.get(t.g.tag_manage_user_identity), sparseArray.get(t.g.tag_forbid_user_name), sparseArray.get(t.g.tag_forbid_user_post_id)});
    }
}
