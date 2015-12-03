package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    private final /* synthetic */ boolean cCo;
    final /* synthetic */ w cHA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(w wVar, boolean z) {
        this.cHA = wVar;
        this.cCo = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.cHA.cEV;
        if (dialog != null) {
            dialog2 = this.cHA.cEV;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cHA.cEV;
                newSubPbActivity2 = this.cHA.cHi;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.cHA.cHi;
            newSubPbActivity.a(this.cCo, (String) sparseArray.get(n.f.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
