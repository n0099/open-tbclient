package com.baidu.tieba.pb.main;

import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bp implements View.OnClickListener {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bm bmVar) {
        this.a = bmVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if (!"".equals(sparseArray.get(com.baidu.tieba.a.h.tag_forbid_user_name)) && !"".equals(sparseArray.get(com.baidu.tieba.a.h.tag_del_post_id))) {
                this.a.a(view);
            } else {
                this.a.a(((Integer) sparseArray.get(com.baidu.tieba.a.h.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.a.h.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.a.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.a.h.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
