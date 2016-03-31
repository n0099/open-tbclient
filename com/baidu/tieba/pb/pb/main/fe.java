package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fe implements View.OnClickListener {
    private final /* synthetic */ boolean dhx;
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(eu euVar, boolean z) {
        this.dnc = euVar;
        this.dhx = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.dnc.dlx;
        if (dialog != null) {
            dialog2 = this.dnc.dlx;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.dnc.dlx;
                pbActivity2 = this.dnc.dfw;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.dnc.dfw;
            pbActivity.a(this.dhx, (String) sparseArray.get(t.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
