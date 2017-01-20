package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ ao esl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(ao aoVar) {
        this.esl = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        NewSubPbActivity newSubPbActivity;
        dialog = this.esl.eoD;
        if (dialog != null) {
            dialog2 = this.esl.eoD;
            if (dialog2 instanceof Dialog) {
                dialog3 = this.esl.eoD;
                newSubPbActivity = this.esl.erI;
                com.baidu.adp.lib.g.j.b(dialog3, newSubPbActivity.getPageContext());
            }
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.esl.a(((Integer) sparseArray.get(r.h.tag_del_post_type)).intValue(), (String) sparseArray.get(r.h.tag_del_post_id), ((Integer) sparseArray.get(r.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.h.tag_del_post_is_self)).booleanValue());
        }
    }
}
