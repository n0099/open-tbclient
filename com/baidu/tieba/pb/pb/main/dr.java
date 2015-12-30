package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements View.OnClickListener {
    private final /* synthetic */ boolean cFU;
    final /* synthetic */ dk cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(dk dkVar, boolean z) {
        this.cKg = dkVar;
        this.cFU = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.cKg.cIU;
        if (dialog != null) {
            dialog2 = this.cKg.cIU;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cKg.cIU;
                pbActivity2 = this.cKg.cGj;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.cKg.cGj;
            pbActivity.a(this.cFU, (String) sparseArray.get(n.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
