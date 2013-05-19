package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements View.OnClickListener {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bl blVar) {
        this.a = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.a.Q;
        if (dialog != null) {
            dialog2 = this.a.Q;
            dialog2.dismiss();
        }
        this.a.a((String) view.getTag(R.id.tag_forbid_user_name), ((Integer) view.getTag(R.id.tag_manage_user_identity)).intValue());
    }
}
