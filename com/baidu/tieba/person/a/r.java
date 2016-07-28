package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q eqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.eqs = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.eqs.mContext, this.eqs.mContext.getResources().getString(u.j.user_set_private)).sa();
    }
}
