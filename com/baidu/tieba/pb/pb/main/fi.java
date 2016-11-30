package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fi implements View.OnClickListener {
    final /* synthetic */ ey eCT;
    private final /* synthetic */ boolean evN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi(ey eyVar, boolean z) {
        this.eCT = eyVar;
        this.evN = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.eCT.eBr;
        if (dialog != null) {
            dialog2 = this.eCT.eBr;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eCT.eBr;
                pbActivity2 = this.eCT.eug;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.eCT.eug;
            pbActivity.a(this.evN, (String) sparseArray.get(r.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
