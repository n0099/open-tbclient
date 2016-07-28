package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ SelectFriendActivity dfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SelectFriendActivity selectFriendActivity) {
        this.dfQ = selectFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dfQ.onBackPressed();
    }
}
