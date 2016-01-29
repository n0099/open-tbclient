package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eh implements View.OnClickListener {
    private final /* synthetic */ boolean cNs;
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(dz dzVar, boolean z) {
        this.cSw = dzVar;
        this.cNs = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.cSw.cQZ;
        if (dialog != null) {
            dialog2 = this.cSw.cQZ;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cSw.cQZ;
                pbActivity2 = this.cSw.cNL;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.cSw.cNL;
            pbActivity.a(this.cNs, (String) sparseArray.get(t.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
