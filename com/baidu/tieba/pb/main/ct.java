package com.baidu.tieba.pb.main;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class ct implements View.OnClickListener {
    final /* synthetic */ bv byW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(bv bvVar) {
        this.byW = bvVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if (!"".equals(sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name)) && !"".equals(sparseArray.get(com.baidu.tieba.v.tag_del_post_id))) {
                this.byW.W(view);
            } else {
                this.byW.a(((Integer) sparseArray.get(com.baidu.tieba.v.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.v.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
