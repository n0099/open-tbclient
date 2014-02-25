package com.baidu.tieba.pb;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements View.OnClickListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.a.K;
        if (dialog != null) {
            dialog2 = this.a.K;
            dialog2.dismiss();
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.a.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
        }
    }
}
