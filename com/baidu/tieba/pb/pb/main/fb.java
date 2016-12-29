package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fb implements View.OnClickListener {
    private final /* synthetic */ boolean eaj;
    final /* synthetic */ er egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(er erVar, boolean z) {
        this.egZ = erVar;
        this.eaj = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.egZ.efx;
        if (dialog != null) {
            dialog2 = this.egZ.efx;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.egZ.efx;
                pbActivity2 = this.egZ.dYB;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.egZ.dYB;
            pbActivity.a(this.eaj, (String) sparseArray.get(r.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
