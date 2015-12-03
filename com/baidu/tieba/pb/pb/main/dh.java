package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements View.OnClickListener {
    private final /* synthetic */ boolean cCo;
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(da daVar, boolean z) {
        this.cGh = daVar;
        this.cCo = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.cGh.cEV;
        if (dialog != null) {
            dialog2 = this.cGh.cEV;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cGh.cEV;
                pbActivity2 = this.cGh.cCy;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.cGh.cCy;
            pbActivity.a(this.cCo, (String) sparseArray.get(n.f.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
