package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ w cMH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.cMH = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(this.cMH.mContext, this.cMH.mContext.getResources().getString(n.i.user_set_private)).tE();
    }
}
