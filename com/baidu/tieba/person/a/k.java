package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j dxJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.dxJ = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.dxJ.mContext;
        context2 = this.dxJ.mContext;
        BdToast.a(context, context2.getResources().getString(t.j.user_set_private)).sd();
    }
}
