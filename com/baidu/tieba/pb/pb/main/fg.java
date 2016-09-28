package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fg implements View.OnClickListener {
    final /* synthetic */ ex ewH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(ex exVar) {
        this.ewH = exVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.ewH.evf;
        if (dialog != null) {
            dialog2 = this.ewH.evf;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.ewH.evf;
                pbActivity = this.ewH.eow;
                com.baidu.adp.lib.h.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        aVar = this.ewH.ewA;
        if (aVar == null) {
            return;
        }
        aVar2 = this.ewH.ewA;
        aVar2.g(new Object[]{sparseArray.get(r.g.tag_manage_user_identity), sparseArray.get(r.g.tag_forbid_user_name), sparseArray.get(r.g.tag_forbid_user_post_id)});
    }
}
