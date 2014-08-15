package com.baidu.tieba.pb.main;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class cr implements View.OnClickListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if (!"".equals(sparseArray.get(com.baidu.tieba.u.tag_forbid_user_name)) && !"".equals(sparseArray.get(com.baidu.tieba.u.tag_del_post_id))) {
                this.a.a(view);
            } else {
                this.a.a(((Integer) sparseArray.get(com.baidu.tieba.u.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.u.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.u.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.u.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
