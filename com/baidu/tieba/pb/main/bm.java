package com.baidu.tieba.pb.main;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ bj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bj bjVar) {
        this.a = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if (!"".equals(sparseArray.get(com.baidu.tieba.r.tag_forbid_user_name)) && !"".equals(sparseArray.get(com.baidu.tieba.r.tag_del_post_id))) {
                this.a.a(view);
            } else {
                this.a.a(((Integer) sparseArray.get(com.baidu.tieba.r.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.r.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.r.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.r.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
