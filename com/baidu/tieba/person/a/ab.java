package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa daI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.daI = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.daI.mContext, this.daI.mContext.getResources().getString(t.j.user_set_private)).us();
    }
}
