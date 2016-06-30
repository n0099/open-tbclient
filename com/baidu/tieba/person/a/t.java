package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s egt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.egt = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.egt.mContext, this.egt.mContext.getResources().getString(u.j.user_set_private)).sb();
    }
}
