package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ s bPU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(s sVar) {
        this.bPU = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
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
            this.bPU.a(((Integer) sparseArray.get(com.baidu.tieba.q.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.q.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue());
        }
    }
}
