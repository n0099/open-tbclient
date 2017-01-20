package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fm implements View.OnClickListener {
    private final /* synthetic */ boolean eiX;
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(ez ezVar, boolean z) {
        this.eqf = ezVar;
        this.eiX = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.eqf.eoD;
        if (dialog != null) {
            dialog2 = this.eqf.eoD;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eqf.eoD;
                pbActivity2 = this.eqf.ehi;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.eqf.ehi;
            pbActivity.a(this.eiX, (String) sparseArray.get(r.h.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
