package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n cMy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.cMy = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(this.cMy.mContext, this.cMy.mContext.getResources().getString(n.i.user_set_private)).tE();
    }
}
