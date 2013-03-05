package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.a.a(this.a, 0, "goto_more", false);
    }
}
