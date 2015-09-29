package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements View.OnClickListener {
    private final /* synthetic */ boolean ciB;
    final /* synthetic */ cc cly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cc ccVar, boolean z) {
        this.cly = ccVar;
        this.ciB = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.cly.ckF;
        if (dialog != null) {
            dialog2 = this.cly.ckF;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cly.ckF;
                pbActivity2 = this.cly.ciJ;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.cly.ciJ;
            pbActivity.a(this.ciB, (String) sparseArray.get(i.f.tag_disable_reply_mute_userid), sparseArray);
        }
    }
}
