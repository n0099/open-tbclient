package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ f deM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.deM = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IMBlackListActivity iMBlackListActivity;
        Object tag = view.getTag();
        if (tag != null && (tag instanceof com.baidu.tieba.im.data.a)) {
            iMBlackListActivity = this.deM.deL;
            iMBlackListActivity.a(view, (com.baidu.tieba.im.data.a) tag);
        }
    }
}
