package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i daj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.daj = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.daj.mContext;
        context2 = this.daj.mContext;
        BdToast.a(context, context2.getResources().getString(t.j.user_set_private)).us();
    }
}
