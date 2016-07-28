package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ z eqB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.eqB = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.eqB.mContext, this.eqB.mContext.getResources().getString(u.j.user_set_private)).sa();
    }
}
