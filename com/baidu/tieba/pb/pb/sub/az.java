package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    private final /* synthetic */ boolean eaj;
    final /* synthetic */ ao ejb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ao aoVar, boolean z) {
        this.ejb = aoVar;
        this.eaj = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.ejb.efx;
        if (dialog != null) {
            dialog2 = this.ejb.efx;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.ejb.efx;
                newSubPbActivity2 = this.ejb.eiy;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.ejb.eiy;
            newSubPbActivity.a(this.eaj, (String) sparseArray.get(r.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
