package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    private final /* synthetic */ boolean ciB;
    final /* synthetic */ t cmM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(t tVar, boolean z) {
        this.cmM = tVar;
        this.ciB = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity newSubPbActivity;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity2;
        dialog = this.cmM.ckF;
        if (dialog != null) {
            dialog2 = this.cmM.ckF;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cmM.ckF;
                newSubPbActivity2 = this.cmM.cmv;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity2.getPageContext());
            }
        }
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            newSubPbActivity = this.cmM.cmv;
            newSubPbActivity.a(this.ciB, (String) sparseArray.get(i.f.tag_disable_reply_mute_userid), sparseArray);
        }
    }
}
