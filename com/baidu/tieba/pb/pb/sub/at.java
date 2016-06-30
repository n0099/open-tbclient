package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    private final /* synthetic */ boolean dPH;
    final /* synthetic */ af dXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(af afVar, boolean z) {
        this.dXy = afVar;
        this.dPH = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.dXy.dUp;
        if (dialog != null) {
            dialog2 = this.dXy.dUp;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.dXy.dUp;
                newSubPbActivity2 = this.dXy.dWU;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.dXy.dWU;
            newSubPbActivity.a(this.dPH, (String) sparseArray.get(u.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
