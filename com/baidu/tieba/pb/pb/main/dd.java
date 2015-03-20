package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class dd implements View.OnClickListener {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if (!"".equals(sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name)) && !"".equals(sparseArray.get(com.baidu.tieba.v.tag_del_post_id))) {
                this.bMm.M(view);
            } else {
                this.bMm.a(((Integer) sparseArray.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
