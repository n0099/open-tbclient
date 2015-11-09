package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList dqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AtSelectFriendList atSelectFriendList) {
        this.dqu = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean ZB;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.dqu.bNw;
        linearLayout.removeView(view);
        ZB = this.dqu.ZB();
        if (!ZB) {
            this.dqu.Zz();
        }
        aVar = this.dqu.dqt;
        if (aVar != null) {
            aVar2 = this.dqu.dqt;
            aVar2.a(view, view.getTag());
        }
    }
}
