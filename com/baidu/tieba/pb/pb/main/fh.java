package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fh implements View.OnClickListener {
    private final /* synthetic */ boolean eod;
    final /* synthetic */ ex euB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(ex exVar, boolean z) {
        this.euB = exVar;
        this.eod = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.euB.esW;
        if (dialog != null) {
            dialog2 = this.euB.esW;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.euB.esW;
                pbActivity2 = this.euB.emy;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.euB.emy;
            pbActivity.a(this.eod, (String) sparseArray.get(t.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
