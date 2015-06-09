package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class cx implements View.OnClickListener {
    final /* synthetic */ ch bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(ch chVar) {
        this.bOG = chVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if (!"".equals(sparseArray.get(com.baidu.tieba.q.tag_forbid_user_name)) && !"".equals(sparseArray.get(com.baidu.tieba.q.tag_del_post_id))) {
                this.bOG.P(view);
            } else {
                this.bOG.a(((Integer) sparseArray.get(com.baidu.tieba.q.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.q.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
