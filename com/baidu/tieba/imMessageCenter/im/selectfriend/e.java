package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ SelectFriendActivity cxy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SelectFriendActivity selectFriendActivity) {
        this.cxy = selectFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cxy.onBackPressed();
    }
}
