package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    private final /* synthetic */ boolean ehA;
    final /* synthetic */ ao erD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ao aoVar, boolean z) {
        this.erD = aoVar;
        this.ehA = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.erD.enO;
        if (dialog != null) {
            dialog2 = this.erD.enO;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.erD.enO;
                newSubPbActivity2 = this.erD.era;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.erD.era;
            newSubPbActivity.a(this.ehA, (String) sparseArray.get(w.h.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
