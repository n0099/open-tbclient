package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r cQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.cQS = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(this.cQS.mContext, this.cQS.mContext.getResources().getString(n.j.user_set_private)).to();
    }
}
