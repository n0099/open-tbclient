package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r daz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.daz = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.daz.mContext, this.daz.mContext.getResources().getString(t.j.user_set_private)).us();
    }
}
