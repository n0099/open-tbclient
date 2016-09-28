package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fh implements View.OnClickListener {
    private final /* synthetic */ boolean eqc;
    final /* synthetic */ ex ewH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(ex exVar, boolean z) {
        this.ewH = exVar;
        this.eqc = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.ewH.evf;
        if (dialog != null) {
            dialog2 = this.ewH.evf;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.ewH.evf;
                pbActivity2 = this.ewH.eow;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.ewH.eow;
            pbActivity.a(this.eqc, (String) sparseArray.get(r.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
