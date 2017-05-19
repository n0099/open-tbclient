package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fw implements View.OnClickListener {
    final /* synthetic */ fm epr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(fm fmVar) {
        this.epr = fmVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        PbActivity.a aVar;
        PbActivity.a aVar2;
        Dialog dialog2;
        Dialog dialog3;
        PbActivity pbActivity;
        dialog = this.epr.enO;
        if (dialog != null) {
            dialog2 = this.epr.enO;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.epr.enO;
                pbActivity = this.epr.efF;
                com.baidu.adp.lib.g.j.b(dialog3, pbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        aVar = this.epr.epk;
        if (aVar == null) {
            return;
        }
        aVar2 = this.epr.epk;
        aVar2.g(new Object[]{sparseArray.get(w.h.tag_manage_user_identity), sparseArray.get(w.h.tag_forbid_user_name), sparseArray.get(w.h.tag_forbid_user_post_id)});
    }
}
