package com.baidu.tieba.pb.main;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class cv implements View.OnClickListener {
    final /* synthetic */ bz bEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(bz bzVar) {
        this.bEC = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if (!"".equals(sparseArray.get(com.baidu.tieba.w.tag_forbid_user_name)) && !"".equals(sparseArray.get(com.baidu.tieba.w.tag_del_post_id))) {
                this.bEC.P(view);
            } else {
                this.bEC.a(((Integer) sparseArray.get(com.baidu.tieba.w.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.w.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.w.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
