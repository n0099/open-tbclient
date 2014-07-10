package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtSelectFriendList atSelectFriendList) {
        this.a = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean d;
        n nVar;
        n nVar2;
        linearLayout = this.a.b;
        linearLayout.removeView(view);
        d = this.a.d();
        if (!d) {
            this.a.b();
        }
        nVar = this.a.h;
        if (nVar != null) {
            nVar2 = this.a.h;
            nVar2.a(view, view.getTag());
        }
    }
}
