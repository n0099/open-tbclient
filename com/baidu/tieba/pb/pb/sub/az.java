package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ ao eIl;
    private final /* synthetic */ boolean ewj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ao aoVar, boolean z) {
        this.eIl = aoVar;
        this.ewj = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.eIl.eCN;
        if (dialog != null) {
            dialog2 = this.eIl.eCN;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eIl.eCN;
                newSubPbActivity2 = this.eIl.eHI;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.eIl.eHI;
            newSubPbActivity.a(this.ewj, (String) sparseArray.get(w.h.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
