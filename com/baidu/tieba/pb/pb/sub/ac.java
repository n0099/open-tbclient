package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ s bPU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(s sVar) {
        this.bPU = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        r rVar;
        r rVar2;
        Dialog dialog2;
        Dialog dialog3;
        TbPageContext tbPageContext;
        dialog = this.bPU.bNM;
        if (dialog != null) {
            dialog2 = this.bPU.bNM;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.bPU.bNM;
                tbPageContext = this.bPU.Yt;
                com.baidu.adp.lib.g.k.b(dialog3, tbPageContext);
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            rVar = this.bPU.bPK;
            if (rVar != null) {
                rVar2 = this.bPU.bPK;
                rVar2.c(new Object[]{sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity), sparseArray.get(com.baidu.tieba.q.tag_forbid_user_name), sparseArray.get(com.baidu.tieba.q.tag_forbid_user_post_id)});
            }
        }
    }
}
