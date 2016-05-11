package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    private final /* synthetic */ boolean djG;
    final /* synthetic */ y dqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(y yVar, boolean z) {
        this.dqN = yVar;
        this.djG = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.dqN.dnR;
        if (dialog != null) {
            dialog2 = this.dqN.dnR;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.dqN.dnR;
                newSubPbActivity2 = this.dqN.dqr;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.dqN.dqr;
            newSubPbActivity.a(this.djG, (String) sparseArray.get(t.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
