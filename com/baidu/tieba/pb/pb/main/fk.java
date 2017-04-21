package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fk implements View.OnClickListener {
    private final /* synthetic */ boolean emm;
    final /* synthetic */ ey etN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(ey eyVar, boolean z) {
        this.etN = eyVar;
        this.emm = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.etN.esg;
        if (dialog != null) {
            dialog2 = this.etN.esg;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.etN.esg;
                pbActivity2 = this.etN.ekw;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.etN.ekw;
            pbActivity.a(this.emm, (String) sparseArray.get(w.h.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
