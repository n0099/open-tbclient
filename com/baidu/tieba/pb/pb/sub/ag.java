package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    private final /* synthetic */ boolean cbq;
    final /* synthetic */ t cgt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(t tVar, boolean z) {
        this.cgt = tVar;
        this.cbq = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.cgt.cep;
        if (dialog != null) {
            dialog2 = this.cgt.cep;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cgt.cep;
                newSubPbActivity2 = this.cgt.cgc;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.cgt.cgc;
            newSubPbActivity.a(this.cbq, (String) sparseArray.get(i.f.tag_disable_reply_mute_userid), sparseArray);
        }
    }
}
