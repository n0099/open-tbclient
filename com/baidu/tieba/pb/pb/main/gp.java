package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gp implements View.OnClickListener {
    final /* synthetic */ gg eEv;
    private final /* synthetic */ boolean ewj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gp(gg ggVar, boolean z) {
        this.eEv = ggVar;
        this.ewj = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.eEv.eCN;
        if (dialog != null) {
            dialog2 = this.eEv.eCN;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eEv.eCN;
                pbActivity2 = this.eEv.euf;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.eEv.euf;
            pbActivity.a(this.ewj, (String) sparseArray.get(w.h.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
