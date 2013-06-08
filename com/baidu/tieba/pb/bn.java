package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements View.OnClickListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.a.P;
        if (dialog != null) {
            dialog2 = this.a.P;
            dialog2.dismiss();
        }
        this.a.a(((Integer) view.getTag(R.id.tag_del_post_type)).intValue(), (String) view.getTag(R.id.tag_del_post_id), ((Integer) view.getTag(R.id.tag_manage_user_identity)).intValue(), ((Boolean) view.getTag(R.id.tag_del_post_is_self)).booleanValue());
    }
}
