package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fc implements View.OnClickListener {
    private final /* synthetic */ boolean dPH;
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(es esVar, boolean z) {
        this.dVR = esVar;
        this.dPH = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity pbActivity;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity2;
        dialog = this.dVR.dUp;
        if (dialog != null) {
            dialog2 = this.dVR.dUp;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.dVR.dUp;
                pbActivity2 = this.dVR.dOg;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            pbActivity = this.dVR.dOg;
            pbActivity.a(this.dPH, (String) sparseArray.get(u.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
