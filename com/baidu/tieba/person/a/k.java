package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j egf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.egf = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.egf.mContext;
        context2 = this.egf.mContext;
        BdToast.a(context, context2.getResources().getString(u.j.user_set_private)).sb();
    }
}
