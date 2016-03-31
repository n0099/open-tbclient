package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ x dpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(x xVar) {
        this.dpf = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        NewSubPbActivity.a aVar;
        NewSubPbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.dpf.dlx;
        if (dialog != null) {
            dialog2 = this.dpf.dlx;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.dpf.dlx;
                newSubPbActivity = this.dpf.doJ;
                com.baidu.adp.lib.h.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            aVar = this.dpf.doY;
            if (aVar != null) {
                aVar2 = this.dpf.doY;
                aVar2.d(new Object[]{sparseArray.get(t.g.tag_manage_user_identity), sparseArray.get(t.g.tag_forbid_user_name), sparseArray.get(t.g.tag_forbid_user_post_id)});
            }
        }
    }
}
