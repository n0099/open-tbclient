package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.view.View;
/* loaded from: classes2.dex */
class f implements View.OnClickListener {
    final /* synthetic */ SelectFriendActivity dtk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity) {
        this.dtk = selectFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dtk.onBackPressed();
    }
}
