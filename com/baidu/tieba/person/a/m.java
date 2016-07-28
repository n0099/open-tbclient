package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l eqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.eqg = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.eqg.mContext;
        context2 = this.eqg.mContext;
        BdToast.a(context, context2.getResources().getString(u.j.user_set_private)).sa();
    }
}
