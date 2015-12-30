package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    private final /* synthetic */ boolean cFU;
    final /* synthetic */ w cLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(w wVar, boolean z) {
        this.cLC = wVar;
        this.cFU = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.cLC.cIU;
        if (dialog != null) {
            dialog2 = this.cLC.cIU;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cLC.cIU;
                newSubPbActivity2 = this.cLC.cLg;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.cLC.cLg;
            newSubPbActivity.a(this.cFU, (String) sparseArray.get(n.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
