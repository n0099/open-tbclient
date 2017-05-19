package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fy implements View.OnClickListener {
    private final /* synthetic */ boolean ehA;
    final /* synthetic */ fm epr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fy(fm fmVar, boolean z) {
        this.epr = fmVar;
        this.ehA = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.epr.enO;
        if (dialog != null) {
            dialog2 = this.epr.enO;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.epr.enO;
                pbActivity2 = this.epr.efF;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.epr.efF;
            pbActivity.a(this.ehA, (String) sparseArray.get(w.h.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
