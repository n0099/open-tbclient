package com.baidu.tieba.write;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList cef;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AtSelectFriendList atSelectFriendList) {
        this.cef = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean On;
        n nVar;
        n nVar2;
        linearLayout = this.cef.mLayout;
        linearLayout.removeView(view);
        On = this.cef.On();
        if (!On) {
            this.cef.Ol();
        }
        nVar = this.cef.cee;
        if (nVar != null) {
            nVar2 = this.cef.cee;
            nVar2.a(view, view.getTag());
        }
    }
}
