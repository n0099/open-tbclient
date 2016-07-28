package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    private final /* synthetic */ boolean ebV;
    final /* synthetic */ af eka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(af afVar, boolean z) {
        this.eka = afVar;
        this.ebV = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.eka.egQ;
        if (dialog != null) {
            dialog2 = this.eka.egQ;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eka.egQ;
                newSubPbActivity2 = this.eka.ejw;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.eka.ejw;
            newSubPbActivity.a(this.ebV, (String) sparseArray.get(u.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
