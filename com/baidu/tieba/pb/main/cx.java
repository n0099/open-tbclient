package com.baidu.tieba.pb.main;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class cx implements View.OnClickListener {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(bz bzVar) {
        this.bCR = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if (!"".equals(sparseArray.get(com.baidu.tieba.w.tag_forbid_user_name)) && !"".equals(sparseArray.get(com.baidu.tieba.w.tag_del_post_id))) {
                this.bCR.N(view);
            } else {
                this.bCR.a(((Integer) sparseArray.get(com.baidu.tieba.w.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.w.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
