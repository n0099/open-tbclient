package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa cRb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.cRb = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(this.cRb.mContext, this.cRb.mContext.getResources().getString(n.j.user_set_private)).to();
    }
}
