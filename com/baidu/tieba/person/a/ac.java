package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ ab dyg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.dyg = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.dyg.mContext, this.dyg.mContext.getResources().getString(t.j.user_set_private)).sd();
    }
}
