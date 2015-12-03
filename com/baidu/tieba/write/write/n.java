package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList dPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AtSelectFriendList atSelectFriendList) {
        this.dPx = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean acH;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.dPx.ccA;
        linearLayout.removeView(view);
        acH = this.dPx.acH();
        if (!acH) {
            this.dPx.acF();
        }
        aVar = this.dPx.dPw;
        if (aVar != null) {
            aVar2 = this.dPx.dPw;
            aVar2.a(view, view.getTag());
        }
    }
}
