package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cMn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cMn = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.cMn.mContext;
        context2 = this.cMn.mContext;
        BdToast.b(context, context2.getResources().getString(n.i.user_set_private)).tE();
    }
}
