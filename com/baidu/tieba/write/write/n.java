package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.write.write.AtSelectFriendList;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ AtSelectFriendList cTr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AtSelectFriendList atSelectFriendList) {
        this.cTr = atSelectFriendList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        boolean YA;
        AtSelectFriendList.a aVar;
        AtSelectFriendList.a aVar2;
        linearLayout = this.cTr.bJe;
        linearLayout.removeView(view);
        YA = this.cTr.YA();
        if (!YA) {
            this.cTr.Yy();
        }
        aVar = this.cTr.cTq;
        if (aVar != null) {
            aVar2 = this.cTr.cTq;
            aVar2.a(view, view.getTag());
        }
    }
}
