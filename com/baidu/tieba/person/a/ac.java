package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ ab egC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.egC = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.egC.mContext, this.egC.mContext.getResources().getString(u.j.user_set_private)).sb();
    }
}
