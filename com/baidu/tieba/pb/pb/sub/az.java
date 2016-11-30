package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ ao eFb;
    private final /* synthetic */ boolean evN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ao aoVar, boolean z) {
        this.eFb = aoVar;
        this.evN = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.eFb.eBr;
        if (dialog != null) {
            dialog2 = this.eFb.eBr;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eFb.eBr;
                newSubPbActivity2 = this.eFb.eEy;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.eFb.eEy;
            newSubPbActivity.a(this.evN, (String) sparseArray.get(r.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
