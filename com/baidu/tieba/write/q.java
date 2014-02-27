package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
final class q implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AtSelectFriendList atSelectFriendList) {
        this.a = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        boolean c;
        r rVar;
        r rVar2;
        linearLayout = this.a.b;
        linearLayout.removeView(view);
        c = this.a.c();
        if (!c) {
            this.a.b();
        }
        rVar = this.a.i;
        if (rVar != null) {
            rVar2 = this.a.i;
            rVar2.a(view.getTag());
        }
    }
}
