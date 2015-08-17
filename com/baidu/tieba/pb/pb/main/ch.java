package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements View.OnClickListener {
    private final /* synthetic */ boolean cbq;
    final /* synthetic */ cb cfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cb cbVar, boolean z) {
        this.cfj = cbVar;
        this.cbq = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.cfj.cep;
        if (dialog != null) {
            dialog2 = this.cfj.cep;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cfj.cep;
                pbActivity2 = this.cfj.cbx;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.cfj.cbx;
            pbActivity.a(this.cbq, (String) sparseArray.get(i.f.tag_disable_reply_mute_userid), sparseArray);
        }
    }
}
