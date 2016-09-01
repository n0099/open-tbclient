package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fg implements View.OnClickListener {
    final /* synthetic */ ex euB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(ex exVar) {
        this.euB = exVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.euB.esW;
        if (dialog != null) {
            dialog2 = this.euB.esW;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.euB.esW;
                pbActivity = this.euB.emy;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        aVar = this.euB.euu;
        if (aVar == null) {
            return;
        }
        aVar2 = this.euB.euu;
        aVar2.g(new Object[]{sparseArray.get(t.g.tag_manage_user_identity), sparseArray.get(t.g.tag_forbid_user_name), sparseArray.get(t.g.tag_forbid_user_post_id)});
    }
}
