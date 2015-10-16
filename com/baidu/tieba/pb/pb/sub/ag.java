package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    private final /* synthetic */ boolean ciM;
    final /* synthetic */ t cmX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(t tVar, boolean z) {
        this.cmX = tVar;
        this.ciM = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.cmX.ckQ;
        if (dialog != null) {
            dialog2 = this.cmX.ckQ;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cmX.ckQ;
                newSubPbActivity2 = this.cmX.cmG;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.cmX.cmG;
            newSubPbActivity.a(this.ciM, (String) sparseArray.get(i.f.tag_disable_reply_mute_userid), sparseArray);
        }
    }
}
