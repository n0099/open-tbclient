package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ w cLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(w wVar) {
        this.cLC = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity.a aVar;
        NewSubPbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.cLC.cIU;
        if (dialog != null) {
            dialog2 = this.cLC.cIU;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cLC.cIU;
                newSubPbActivity = this.cLC.cLg;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            aVar = this.cLC.cLu;
            if (aVar != null) {
                aVar2 = this.cLC.cLu;
                aVar2.d(new Object[]{sparseArray.get(n.g.tag_manage_user_identity), sparseArray.get(n.g.tag_forbid_user_name), sparseArray.get(n.g.tag_forbid_user_post_id)});
            }
        }
    }
}
