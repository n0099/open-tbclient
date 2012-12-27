package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.a.a(this.a, 0, "goto_more", false);
    }
}
