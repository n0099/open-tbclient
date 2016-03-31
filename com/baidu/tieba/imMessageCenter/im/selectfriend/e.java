package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ SelectFriendActivity cwB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SelectFriendActivity selectFriendActivity) {
        this.cwB = selectFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cwB.onBackPressed();
    }
}
