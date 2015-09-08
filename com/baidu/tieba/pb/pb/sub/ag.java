package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    private final /* synthetic */ boolean ccl;
    final /* synthetic */ t chq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(t tVar, boolean z) {
        this.chq = tVar;
        this.ccl = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.chq.cfm;
        if (dialog != null) {
            dialog2 = this.chq.cfm;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.chq.cfm;
                newSubPbActivity2 = this.chq.cgZ;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.chq.cgZ;
            newSubPbActivity.a(this.ccl, (String) sparseArray.get(i.f.tag_disable_reply_mute_userid), sparseArray);
        }
    }
}
