package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ f bMM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.bMM = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IMBlackListActivity iMBlackListActivity;
        Object tag = view.getTag();
        if (tag != null && (tag instanceof com.baidu.tieba.im.data.a)) {
            iMBlackListActivity = this.bMM.bMK;
            iMBlackListActivity.a(view, (com.baidu.tieba.im.data.a) tag);
        }
    }
}
