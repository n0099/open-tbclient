package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s dxX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.dxX = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.dxX.mContext, this.dxX.mContext.getResources().getString(t.j.user_set_private)).sd();
    }
}
