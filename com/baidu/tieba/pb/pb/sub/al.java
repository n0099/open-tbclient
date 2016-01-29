package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    private final /* synthetic */ boolean cNs;
    final /* synthetic */ w cUl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(w wVar, boolean z) {
        this.cUl = wVar;
        this.cNs = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.cUl.cQZ;
        if (dialog != null) {
            dialog2 = this.cUl.cQZ;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cUl.cQZ;
                newSubPbActivity2 = this.cUl.cTO;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.cUl.cTO;
            newSubPbActivity.a(this.cNs, (String) sparseArray.get(t.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
