package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    private final /* synthetic */ boolean cjP;
    final /* synthetic */ v coo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(v vVar, boolean z) {
        this.coo = vVar;
        this.cjP = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.coo.cme;
        if (dialog != null) {
            dialog2 = this.coo.cme;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.coo.cme;
                newSubPbActivity2 = this.coo.cnX;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.coo.cnX;
            newSubPbActivity.a(this.cjP, (String) sparseArray.get(i.f.tag_disable_reply_mute_userid), sparseArray);
        }
    }
}
