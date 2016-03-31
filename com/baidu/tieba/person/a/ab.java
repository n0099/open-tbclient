package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa dvk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.dvk = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.dvk.mContext, this.dvk.mContext.getResources().getString(t.j.user_set_private)).ux();
    }
}
