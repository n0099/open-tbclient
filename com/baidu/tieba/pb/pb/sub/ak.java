package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ w cUl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(w wVar) {
        this.cUl = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity.a aVar;
        NewSubPbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.cUl.cQZ;
        if (dialog != null) {
            dialog2 = this.cUl.cQZ;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.cUl.cQZ;
                newSubPbActivity = this.cUl.cTO;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            aVar = this.cUl.cUd;
            if (aVar != null) {
                aVar2 = this.cUl.cUd;
                aVar2.d(new Object[]{sparseArray.get(t.g.tag_manage_user_identity), sparseArray.get(t.g.tag_forbid_user_name), sparseArray.get(t.g.tag_forbid_user_post_id)});
            }
        }
    }
}
