package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList dco;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AtSelectFriendList atSelectFriendList) {
        this.dco = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean YC;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.dco.bJL;
        linearLayout.removeView(view);
        YC = this.dco.YC();
        if (!YC) {
            this.dco.YA();
        }
        aVar = this.dco.dcn;
        if (aVar != null) {
            aVar2 = this.dco.dcn;
            aVar2.a(view, view.getTag());
        }
    }
}
