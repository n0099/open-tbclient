package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    private final /* synthetic */ boolean eod;
    final /* synthetic */ ag ewi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ag agVar, boolean z) {
        this.ewi = agVar;
        this.eod = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.ewi.esW;
        if (dialog != null) {
            dialog2 = this.ewi.esW;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.ewi.esW;
                newSubPbActivity2 = this.ewi.evD;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.ewi.evD;
            newSubPbActivity.a(this.eod, (String) sparseArray.get(t.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
