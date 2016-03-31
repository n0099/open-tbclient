package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    private final /* synthetic */ boolean dhx;
    final /* synthetic */ x dpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(x xVar, boolean z) {
        this.dpf = xVar;
        this.dhx = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.dpf.dlx;
        if (dialog != null) {
            dialog2 = this.dpf.dlx;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.dpf.dlx;
                newSubPbActivity2 = this.dpf.doJ;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.dpf.doJ;
            newSubPbActivity.a(this.dhx, (String) sparseArray.get(t.g.tag_user_mute_mute_userid), sparseArray);
        }
    }
}
