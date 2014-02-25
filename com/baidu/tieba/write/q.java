package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AtSelectFriendList atSelectFriendList) {
        this.a = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean d;
        r rVar;
        r rVar2;
        linearLayout = this.a.b;
        linearLayout.removeView(view);
        d = this.a.d();
        if (!d) {
            this.a.b();
        }
        rVar = this.a.i;
        if (rVar != null) {
            rVar2 = this.a.i;
            rVar2.a(view, view.getTag());
        }
    }
}
