package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i duN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.duN = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.duN.mContext;
        context2 = this.duN.mContext;
        BdToast.a(context, context2.getResources().getString(t.j.user_set_private)).ux();
    }
}
