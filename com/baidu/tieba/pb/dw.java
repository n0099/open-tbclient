package com.baidu.tieba.pb;

import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dw implements View.OnClickListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) && !"".equals(sparseArray.get(R.id.tag_del_post_id))) {
                this.a.a(view);
            } else {
                this.a.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }
}
