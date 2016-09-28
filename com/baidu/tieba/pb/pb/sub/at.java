package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ ag eyq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ag agVar) {
        this.eyq = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity.a aVar;
        NewSubPbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.eyq.evf;
        if (dialog != null) {
            dialog2 = this.eyq.evf;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.eyq.evf;
                newSubPbActivity = this.eyq.exK;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            aVar = this.eyq.eyg;
            if (aVar != null) {
                aVar2 = this.eyq.eyg;
                aVar2.g(new Object[]{sparseArray.get(r.g.tag_manage_user_identity), sparseArray.get(r.g.tag_forbid_user_name), sparseArray.get(r.g.tag_forbid_user_post_id)});
            }
        }
    }
}
