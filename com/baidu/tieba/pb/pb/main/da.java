package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements View.OnClickListener {
    private final /* synthetic */ boolean cjP;
    final /* synthetic */ ct cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(ct ctVar, boolean z) {
        this.cmY = ctVar;
        this.cjP = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.cmY.cme;
        if (dialog != null) {
            dialog2 = this.cmY.cme;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cmY.cme;
                pbActivity2 = this.cmY.cjZ;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.cmY.cjZ;
            pbActivity.a(this.cjP, (String) sparseArray.get(i.f.tag_disable_reply_mute_userid), sparseArray);
        }
    }
}
